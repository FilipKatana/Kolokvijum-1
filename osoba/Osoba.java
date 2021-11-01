package osoba;

import ispis.Ispisivo;
import zadatak.Izvrsivo;
import zadatak.RadniZadatak;

public class Osoba implements Izvrsivo, Runnable {
	private String ime, prezime;
	private RadniZadatak zadatak;
	
	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	public void dodeli(RadniZadatak z) {
		this.zadatak = z;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public void ispisi() {
		System.out.println("Osoba sa imenom: "  + this.ime + " i prezimenom: " + this.prezime);
		
	}
	@Override
	public void run() {
		
		
	}


	
	
}
