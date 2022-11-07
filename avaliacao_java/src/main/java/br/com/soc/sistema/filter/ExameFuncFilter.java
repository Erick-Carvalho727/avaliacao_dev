package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesComboBuscarExamesFunc;

public class ExameFuncFilter {
    private OpcoesComboBuscarExamesFunc opcoesCombo;
    private String valorBusca;

    public String getValorBusca() {
        return valorBusca;
    }

    public ExameFuncFilter setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
        return this;
    }

    public OpcoesComboBuscarExamesFunc getOpcoesCombo() {
        return opcoesCombo;
    }

    public ExameFuncFilter setOpcoesCombo(String codigo) {
        this.opcoesCombo = OpcoesComboBuscarExamesFunc.buscarPor(codigo);
        return this;
    }

    public boolean isNullOpcoesCombo() {
        return this.getOpcoesCombo() == null;
    }

    public static ExameFuncFilter builder() {
        return new ExameFuncFilter();
    }



}
