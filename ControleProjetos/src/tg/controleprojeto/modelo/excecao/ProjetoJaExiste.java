package tg.controleprojeto.modelo.excecao;

public class ProjetoJaExiste extends Exception{

	public ProjetoJaExiste(String mensagem){
		super(mensagem);
	}
}
