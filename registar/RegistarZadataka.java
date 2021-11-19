package registar;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import osoba.Osoba;
import zadatak.Izvrsivo;
import zadatak.RadniZadatak;
import zadatak.StatusZadatka;

public class RegistarZadataka implements Izvrsivo {
	private ArrayList<RadniZadatak> zadaci = new ArrayList<RadniZadatak>();
	private ArrayList<RadniZadatak> izvrseni = new ArrayList<RadniZadatak>();
	
	
	private Semaphore zadaciDozvola = new Semaphore(1);
	private Semaphore izvrseniDozvola = new Semaphore(1);
	
	
	public RegistarZadataka(RadniZadatak ...zadaci) {
		for (RadniZadatak x : zadaci) {
			this.zadaci.add(x);
		}
	}
	
	public void dodaj(RadniZadatak r) {
		this.zadaciDozvola.acquireUninterruptibly();
		this.zadaci.add(r);
		this.zadaciDozvola.release();
	}
	
	public void ukloni(int i) {
		this.zadaci.remove(i);
	}
	
	public void ukloni(RadniZadatak z) {
		this.zadaci.remove(z);
	}
	
	public int velicina() {
		return this.zadaci.size();
	}
	
	public RadniZadatak dobavi(int index) {
		return this.zadaci.get(index);
	}
	
	public void dodajIzvrsen(RadniZadatak z) {
		this.izvrseniDozvola.acquireUninterruptibly();
		this.izvrseni.add(z);
		this.izvrseniDozvola.release();
	}

	@Override
	public void ispisi() {
		System.out.println("Registar zadataka: ");
		
		for (RadniZadatak z : this.zadaci) {
			z.ispisi();
		}
		
	}
	
	
	public RadniZadatak zahtevaj(Osoba o) {
		while (this.zadaci.size() == 0);
		this.zadaciDozvola.acquireUninterruptibly();
		int index = (int) (Math.random()*this.zadaci.size());
		this.zadaci.get(index).dodeliOsobu(o);
		RadniZadatak r = this.zadaci.remove(index);
		this.zadaciDozvola.release();
		return r;	
	}
	
	public void izvrseniPrint() {
		for (RadniZadatak r : this.izvrseni) {
			r.ispisi();
		}
	}
	
}
