package zadatak;

import java.time.LocalDateTime;

import osoba.Osoba;
import uredjaj.Uredjaj;

public abstract class ZadatakNadPredmetom extends RadniZadatak {
	private Izvrsivo predmetZadatka;

	public ZadatakNadPredmetom(String naziv, String opis, Osoba zaduzenaOsoba, Izvrsivo predmetZadatka) {
		super(naziv, opis, zaduzenaOsoba);
		this.predmetZadatka = predmetZadatka;
	}

	public Izvrsivo getPredmetZadatka() {
		return predmetZadatka;
	}
	
	
	
}
