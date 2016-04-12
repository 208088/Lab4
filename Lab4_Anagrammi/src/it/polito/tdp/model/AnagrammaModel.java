package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.ContieneDAO;

public class AnagrammaModel {
	List<RichWord> lista;
	
	public List<RichWord> getAnagrammi(String parola) {
		// TODO Auto-generated method stub
		int fatto=0;
		lista= new ArrayList<RichWord>();
		cerca(parola, fatto);
		ContieneDAO contiene= new ContieneDAO();
		return contiene.contiene(lista);
	}

	private void cerca(String parola, int fatto) {
		boolean gia=false;
		if(fatto==parola.length()){
			for (RichWord r : lista) {
				if(r.getParola().compareTo(parola)==0){
					gia=true;
						break;
				}
			}
			if(!gia)
				lista.add(new RichWord(parola, false));
			return;
		}
		
			for (int k = 0; k <=fatto; k++) {
				char[] c= parola.toCharArray();
				for (int i = 0; i < c.length; i++) {
				char d=c[i];
				c[i]= c[k];
				c[k]=d;
				cerca(String.copyValueOf(c), fatto+1);
				}
			
		}
	}

	//metodo iterativo e non ricorsivo
	
	public List<RichWord> getAnagramma(String parola){
		lista= new ArrayList<RichWord>();
		boolean esiste=false;
		char[] par=parola.toCharArray();
		for (int i = 0; i < par.length; i++) {
			for (int j = 0; j < par.length; j++) {
				char c= par[i];
				par[i]=par[j];
				par[j]=c;
				esiste=false;
				for (RichWord r : lista) {
					if(r.getParola().compareTo(String.copyValueOf(par))==0){
						esiste=true; break;
					}
				}
				if(!esiste)
					lista.add(new RichWord(String.copyValueOf(par), false));
			}
		for (int j = par.length-1; j>= 0; j--) {
			char c= par[i];
			par[i]=par[j];
			par[j]=c;
			esiste=false;
			for (RichWord r : lista) {
				if(r.getParola().compareTo(String.copyValueOf(par))==0){
					esiste=true; break;
				}
			}
			if(!esiste)
				lista.add(new RichWord(String.copyValueOf(par), false));
		}
		}
		ContieneDAO contiene= new ContieneDAO();
		return contiene.contiene(lista);
		
	}

}
