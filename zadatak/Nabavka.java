package zadatak;

import java.time.LocalDateTime;

import osoba.Osoba;
import uredjaj.Uredjaj;

public class Nabavka extends RadniZadatak {
	private int kolicina;

	public Nabavka(String naziv, String opis, Izvrsivo predmetZadatka, int kolicina) {
		super(naziv, opis, predmetZadatka);
		this.kolicina = kolicina;
	}
	
	public void ispisi() {
		super.ispisi();
		System.out.println("Tipa nabavka " + this.kolicina);
	}
	
	
}
