package br.com.soc.sistema.infra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.soc.sistema.exception.BusinessException;

public enum OpcoesComboBuscarExamesFunc {

    ID("1", "ID"),
    NOME_F("2", "NOME DO FUNCIONARIO"),
    NOME_E("3", "NOME DO EXAME");

    private String codigo;
    private String descricao;
    private final static Map<String, OpcoesComboBuscarExamesFunc> opcoes = new HashMap<>();

    static {
        Arrays.asList(OpcoesComboBuscarExamesFunc.values())
        .forEach(
                opcao -> opcoes.put(opcao.getCodigo(), opcao)
        );
    }

    private OpcoesComboBuscarExamesFunc(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OpcoesComboBuscarExamesFunc buscarPor(String codigo) throws IllegalArgumentException {
        if(codigo == null)
            throw new IllegalArgumentException("informe um codigo valido");

        OpcoesComboBuscarExamesFunc opcao = getOpcao(codigo)
                .orElseThrow(() -> new BusinessException("Codigo informado nao existe"));

        return opcao;
    }

    private static Optional<OpcoesComboBuscarExamesFunc> getOpcao(String codigo){
        return Optional.ofNullable(opcoes.get(codigo));
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
