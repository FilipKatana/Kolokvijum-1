package zadatak;

import java.time.LocalDateTime;

import osoba.Osoba;
import uredjaj.Uredjaj;

public class Odrzavanje extends ZadatakNadPredmetom {
	private String opisPopravke;

	public Odrzavanje(String naziv, String opis, Osoba oso, Izvrsivo predmetZadatka, String opisPopravke) {
		super(naziv, opis, oso, predmetZadatka);
		this.opisPopravke = opisPopravke;
	}

	public String getOpisPopravke() {
		return opisPopravke;
	}
	
	public void ispisi() {
		super.ispisi();
		System.out.println("Opis održavanja: " + this.opisPopravke);
	}	
	
	

}
