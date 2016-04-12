package it.polito.tdp.model;

public class RichWord {
	private String parola;
	private boolean esiste;
	public RichWord(String parola, boolean esiste) {
		super();
		this.parola = parola;
		this.esiste = esiste;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isEsiste() {
		return esiste;
	}
	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	}
	

}
