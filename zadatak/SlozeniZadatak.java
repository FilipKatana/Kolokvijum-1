package zadatak;

import java.util.ArrayList;

import osoba.Osoba;

public class SlozeniZadatak extends ZadatakNadPredmetom implements Izvrsivo {
	private ArrayList<RadniZadatak> zadaci = new ArrayList<RadniZadatak>();

	public SlozeniZadatak(String naziv, String opis, Osoba zaduzenaOsoba, Izvrsivo predmetZadatka, RadniZadatak ...zadaci) {
		super(naziv, opis, zaduzenaOsoba, predmetZadatka);


		for (RadniZadatak x : zadaci) {
			this.zadaci.add(x);
		}
	}
	
	public boolean isSlozen() {
		return true;
	}
	
	public void dodaj(RadniZadatak r) {
		this.zadaci.add(r);
	}
	
	public void ukloni(int i) {
		this.zadaci.remove(i);
	}
	
	public int velicina() {
		return this.zadaci.size();
	}
	
	public RadniZadatak dobavi(int index) {
		return this.zadaci.get(index);
	}
	
	public void ispisi(int dubina) {
		super.ispisi();
		if (dubina <= 0) {
			return;
		}
		System.out.println("Podzadaci:");
		for (RadniZadatak z : this.zadaci) {
			if (z.isSlozen()) {
				((SlozeniZadatak) z).ispisi(dubina - 1);
			} else {
				z.ispisi();
			}
			System.out.println("**********************");
		}
	}
	
	public void ispisi() {
		this.ispisi(100);
	}
	
	
}
