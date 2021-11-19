package zadatak;

import java.time.LocalDateTime;
import osoba.Osoba;
import registar.RegistarZadataka;

public abstract class RadniZadatak implements Izvrsivo {
	private String naziv, opis;
	private LocalDateTime vremeIzdavanja;
	private LocalDateTime vremeZavrsetka;
	private StatusZadatka status;
	private Osoba zaduzenaOsoba;
	private Izvrsivo predmetZadatka;
	
	
	public RadniZadatak(String naziv, String opis, Izvrsivo predmetZadatka) {
		this.naziv = naziv;
		this.opis = opis;
		this.vremeIzdavanja = LocalDateTime.now();
		this.status = StatusZadatka.ZADAT;
		this.predmetZadatka = predmetZadatka;
	}
	public String getNaziv() {
		return naziv;
	}
	public String getOpis() {
		return opis;
	}
	public LocalDateTime getVremeIzdavanja() {
		return vremeIzdavanja;
	}
	public LocalDateTime getVremeZavrsetka() {
		return vremeZavrsetka;
	}
	public StatusZadatka getStatus() {
		return status;
	}
	
	public void dodeliOsobu(Osoba o) {
		this.zaduzenaOsoba = o;
	}
	
	public boolean isSlozen() {
		return false;
	}
	
	public void ispisi() {
		System.out.println("Zadatak " + this.naziv + " od " + ((this.zaduzenaOsoba == null) ? "NULL" : this.zaduzenaOsoba.getIme()));
	}
	
	public void setStatus(StatusZadatka s) {
		this.status = s;
	}

	public Izvrsivo getPredmetZadatka() {
		return predmetZadatka;
	}
	
	
	
	
	
	
}
