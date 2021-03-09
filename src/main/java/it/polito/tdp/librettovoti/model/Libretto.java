package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public String toString() {
		String s ="";
		for(Voto v:this.voti) {
			s=s+v.toString()+"\n";
		}
		return s;
	}
	public Libretto votiUguali(int punteggio) {
		Libretto risultato= new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
	}
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome
	 * Se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato = null ;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato = v ;
				break ;
			}
		}
		return risultato ;
	}
}
