package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.examesFunc.ExameFuncDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameFuncFilter;
import br.com.soc.sistema.vo.ExameFuncVo;
import br.com.soc.sistema.vo.ExameVo;

public class ExameFuncBusiness {

    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";

    private ExameFuncDao dao;

    public ExameFuncBusiness() {
        this.dao = new ExameFuncDao();
    }

    public void salvarExameFunc(ExameFuncVo exameFuncVo) {
        try {
            if(exameFuncVo.getRowidFunc().isEmpty())
                throw new IllegalArgumentException("Precisa do ID do funcionario");
            if(exameFuncVo.getRowid().isEmpty())
                throw new IllegalArgumentException("Precisa do ID do exame");
            if(exameFuncVo.getDataExame().isEmpty())
                throw new IllegalArgumentException("Precisa da data do exame");

            dao.insertExameFunc(exameFuncVo);
        } catch (Exception e) {
            throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
        }

    }

    public void editarExameFunc(ExameFuncVo exameFuncVo) {
        try {
            if(exameFuncVo.getRowidFunc().isEmpty())
                throw new IllegalArgumentException("Não pode alterar o ID do funcionario para branco");
            if(exameFuncVo.getRowid().isEmpty())
                throw new IllegalArgumentException("Não pode alterar o ID do exame para branco");
            if(exameFuncVo.getDataExame().isEmpty())
                throw new IllegalArgumentException("Não pode alterar a data do exame para branco");

            dao.updateExameFunc(exameFuncVo);
        } catch (Exception e) {
            throw new BusinessException("Nao foi possivel editar o registro");
        }

    }

    public ExameFuncVo buscarExameFuncRelatorio(String codigo) {
        try {
            Integer cod = Integer.parseInt(codigo);
            return dao.findByCodigoRelatorio(cod);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }


    public ExameFuncVo buscarExameFuncPor(String codigo) {
        try {
            Integer cod = Integer.parseInt(codigo);
            return dao.findByCodigo(cod);
        }catch (NumberFormatException e) {
            throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
        }
    }

    public void excluirExameFunc(ExameFuncVo exameFuncVo) {
        try {

            dao.deleteExameFunc(exameFuncVo);
        } catch (Exception e) {
            throw new BusinessException("Nao foi possivel deletar");
        }

    }

    public List<ExameFuncVo> filtrarExamesFunc(ExameFuncFilter filter){
        List<ExameFuncVo> examesFunc = new ArrayList<>();

        switch (filter.getOpcoesCombo()) {
            case ID:
                try {
                    Integer codigo = Integer.parseInt(filter.getValorBusca());
                    examesFunc.add(dao.findByCodigo(codigo));
                }catch (NumberFormatException e) {
                    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
                }
                break;

            case NOME_F:
                examesFunc.addAll(dao.findAllByNomeFunc(filter.getValorBusca()));
                break;

            case NOME_E:
                examesFunc.addAll(dao.findAllByNomeExame(filter.getValorBusca()));
                break;
        }

        return examesFunc;
    }

    public List<ExameFuncVo> trazerTodosOsExamesFunc(){
        return dao.findAllExamesFunc();
    }

}
