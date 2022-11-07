package br.com.soc.sistema.action.exameFunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameFuncBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscarExamesFunc;
import br.com.soc.sistema.infra.OpcoesComboBuscarFuncionarios;
import br.com.soc.sistema.vo.ExameFuncVo;
import br.com.soc.sistema.filter.ExameFuncFilter;
import br.com.soc.sistema.vo.ExameVo;


public class ExameFuncAction extends Action {

    private List<ExameFuncVo> exameFuncs = new ArrayList<>();
    private ExameFuncVo exameFuncVo = new ExameFuncVo();
    private ExameFuncFilter filtrar = new ExameFuncFilter();
    private ExameFuncBusiness business = new ExameFuncBusiness();


    public String todos() {
        exameFuncs.addAll(business.trazerTodosOsExamesFunc());

        return SUCCESS;
    }

    public String filtrar() {
        if(filtrar.isNullOpcoesCombo())
            return REDIRECT;

        exameFuncs = business.filtrarExamesFunc(filtrar);

        return SUCCESS;
    }

    public String novo() {
        if(exameFuncVo.getDataExame() == null && exameFuncVo.getRowidFunc() == null && exameFuncVo.getRowid() == null)
            return INPUT;

        business.salvarExameFunc(exameFuncVo);

        return REDIRECT;
    }

    public String pegar() {
        if(exameFuncVo.getRowidExameFunc() == null)
            return REDIRECT;

        exameFuncVo = business.buscarExameFuncPor(exameFuncVo.getRowidExameFunc());

        return INPUT;
    }

    public String relatorio() {
        if(exameFuncVo.getRowidExameFunc() == null)
            return REDIRECT;

        exameFuncVo = business.buscarExameFuncRelatorio(exameFuncVo.getRowidExameFunc());

        return INPUT;
    }

    public String editar() {
        if(exameFuncVo.getRowidExameFunc() == null)
            return REDIRECT;

        business.editarExameFunc(exameFuncVo);

        return SUCCESS;
    }

    public String excluir() {
        business.excluirExameFunc(exameFuncVo);

        return SUCCESS;
    }

    public List<OpcoesComboBuscarExamesFunc> getListaOpcoesCombo(){
        return Arrays.asList(OpcoesComboBuscarExamesFunc.values());
    }

    public void setExameFuncs(List<ExameFuncVo> exameFuncs) {
        this.exameFuncs = exameFuncs;
    }

    public List<ExameFuncVo> getExameFuncs() {
        return exameFuncs;
    }

    public ExameFuncVo getExameFuncVo() {
        return exameFuncVo;
    }

    public void setExameFuncVo(ExameFuncVo exameFuncVo) {
        this.exameFuncVo = exameFuncVo;
    }
}
