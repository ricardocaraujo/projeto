package tg.controleprojeto.modelo.negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Projeto {
	
	private int idProjeto; 
	private String justificativa;
	private String nomeProjeto;
	private String objetivo;
	private Calendar dataInicio;
	private Calendar dataFim;
	private List<Empregado> coordenadores;
	private Empregado responsavelTecnico;
	private List<Empregado> participantes;
	private Gerencia gerenciaCliente;
	private Gerencia gerenciaExecutora;
	 
	 
	public Projeto(){}


	public Projeto(int idProjeto, String justificativa, 
			String nomeProjeto, String objetivo, Calendar dataInicio,
			Calendar dataFim, List<Empregado> coordenadores,
			Empregado responsavelTecnico, List<Empregado> participantes,
			Gerencia gerenciaCliente, Gerencia gerenciaExecutora) {
		this.idProjeto = idProjeto;
		this.justificativa = justificativa;
		this.nomeProjeto = nomeProjeto;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.coordenadores = coordenadores;
		this.responsavelTecnico = responsavelTecnico;
		this.participantes = participantes;
		this.gerenciaCliente = gerenciaCliente;
		this.gerenciaExecutora = gerenciaExecutora;
	}


	public int getIdProjeto() {
		return idProjeto;
	}


	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}


	public String getJustificativa() {
		return justificativa;
	}


	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}


	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}


	public String getObjetivo() {
		return objetivo;
	}


	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}


	public Calendar getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Calendar getDataFim() {
		return dataFim;
	}


	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}


	public List<Empregado> getCoordenador() {
		return coordenadores;
	}


	public void setCoordenador(List<Empregado> coordenadores) {
		this.coordenadores = coordenadores;
	}


	public Empregado getResponsavelTecnico() {
		return responsavelTecnico;
	}


	public void setResponsavelTecnico(Empregado responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}


	public List<Empregado> getParticipantes() {
		return participantes;
	}


	public void setParticipantes(List<Empregado> participantes) {
		this.participantes = participantes;
	}


	public Gerencia getGerenciaCliente() {
		return gerenciaCliente;
	}


	public void setGerenciaCliente(Gerencia gerenciaCliente) {
		this.gerenciaCliente = gerenciaCliente;
	}


	public Gerencia getGerenciaExecutora() {
		return gerenciaExecutora;
	}


	public void setGerenciaExecutora(Gerencia gerenciaExecutora) {
		this.gerenciaExecutora = gerenciaExecutora;
	}
	 
	 	 	 
}
