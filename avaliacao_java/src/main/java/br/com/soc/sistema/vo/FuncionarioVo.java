package br.com.soc.sistema.vo;

public class FuncionarioVo {
	private String rowidFunc;
	private String nomeF;	
	
	public FuncionarioVo() {}
		
	public FuncionarioVo(String rowidFunc, String nomeF) {
		this.rowidFunc = rowidFunc;
		this.nomeF = nomeF;
	}

	public String getRowidFunc() {
		return rowidFunc;
	}
	public void setRowidFunc(String rowidFunc) {
		this.rowidFunc = rowidFunc;
	}
	public String getNomeF() {
		return nomeF;
	}
	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}
	
	@Override
	public String toString() {
		return "FuncionarioVo [rowidFunc=" + rowidFunc + ", nomeF=" + nomeF + "]";
	}

}
