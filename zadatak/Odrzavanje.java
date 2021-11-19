package zadatak;

import java.time.LocalDateTime;

import osoba.Osoba;
import uredjaj.Uredjaj;

public class Odrzavanje extends RadniZadatak {
	private String opisPopravke;

	public Odrzavanje(String naziv, String opis, Izvrsivo predmetZadatka, String opisPopravke) {
		super(naziv, opis, predmetZadatka);
		this.opisPopravke = opisPopravke;
	}

	public String getOpisPopravke() {
		return opisPopravke;
	}
	
	public void ispisi() {
		super.ispisi();
		System.out.println("Opis odr�avanja: " + this.opisPopravke);
	}	
	
	

}
