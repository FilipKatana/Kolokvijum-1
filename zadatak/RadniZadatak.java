package zadatak;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

import osoba.Osoba;
import registar.RegistarZadataka;

public abstract class RadniZadatak implements Izvrsivo {
	private String naziv, opis;
	private LocalDateTime vremeIzdavanja;
	private LocalDateTime vremeZavrsetka;
	private StatusZadatka status;
	private Osoba zaduzenaOsoba;
	private RegistarZadataka registar;
	
	private Semaphore dozvola = new Semaphore(1);
	
	public RadniZadatak(String naziv, String opis, Osoba zaduz) {
		this.naziv = naziv;
		this.opis = opis;
		this.vremeIzdavanja = LocalDateTime.now();
		this.status = StatusZadatka.ZADAT;
		this.zaduzenaOsoba = null;
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
	
	
	public boolean isSlozen() {
		return false;
	}
	
	public void ispisi() {
		System.out.println("Zadatak " + this.naziv + " od " + ((this.zaduzenaOsoba == null) ? "NULL" : this.zaduzenaOsoba.getIme()));
	}
	
	public void setRegistar(RegistarZadataka reg) {
		this.registar = reg;
	}
	
	public void zatrazi(Osoba o) {
		this.dozvola.acquireUninterruptibly();
		if (this.zaduzenaOsoba == null) {
			this.zaduzenaOsoba = o;
			this.status = StatusZadatka.OTPOCET;
		}
		this.dozvola.release();
	}
	
	
	
	
	
	
}
