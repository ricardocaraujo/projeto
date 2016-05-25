package tg.controleprojeto.modelo.negocio;

public class Gerencia {
	
	private int id;
	private String nome;
	
	public Gerencia() {}
	
	public Gerencia(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
