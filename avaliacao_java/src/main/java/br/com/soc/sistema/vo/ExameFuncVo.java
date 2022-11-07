package br.com.soc.sistema.vo;


public class ExameFuncVo {

    private String rowidExameFunc;

    private String rowid;

    private String nomeFunc;

    private String nomeExame;

    private String rowidFunc;

    private String dataExame;

    public ExameFuncVo() {}

    public ExameFuncVo(String rowid, String rowidFunc, String rowidExameFunc, String dataExame, String nomeFunc, String nomeExame) {
        this.rowid = rowid;
        this.rowidFunc = rowidFunc;
        this.rowidExameFunc = rowidExameFunc;
        this.dataExame = dataExame;
        this.nomeFunc = nomeFunc;
        this.nomeExame = nomeExame;

    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getRowidExameFunc() {
        return rowidExameFunc;
    }

    public void setRowidExameFunc(String rowidExameFunc) {
        this.rowidExameFunc = rowidExameFunc;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public String getRowidFunc() {
        return rowidFunc;
    }

    public void setRowidFunc(String rowidFunc) {
        this.rowidFunc = rowidFunc;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    @Override
    public String toString() {
        return "ExameFuncVo [rowid do exame=" + rowid + ", rowid do funcionario=" + rowidFunc
                + ", data do exame=" + dataExame + "]";
    }

}
