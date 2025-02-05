package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[]args) {
		
		System.out.println("Test metodi Libretto");
		Libretto libretto = new Libretto();
		Voto voto1= new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		libretto.add(voto1);
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)));
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 2, 8)));
		System.out.println(libretto);
		
		Libretto venticinque= libretto.votiUguali(25);
		System.out.println(venticinque);
		
		Voto analisi = libretto.ricercaCorso("Analisi 1");
		System.out.println(analisi);
	}
}
