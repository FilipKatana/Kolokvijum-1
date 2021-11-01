package registar;

import java.util.ArrayList;

import zadatak.Izvrsivo;
import zadatak.RadniZadatak;

public class RegistarZadataka implements Izvrsivo {
	private ArrayList<RadniZadatak> zadaci = new ArrayList<RadniZadatak>();
	
	public RegistarZadataka(RadniZadatak ...zadaci) {
		for (RadniZadatak x : zadaci) {
			this.zadaci.add(x);
		}
	}
	
	public void dodaj(RadniZadatak r) {
		this.zadaci.add(r);
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

	@Override
	public void ispisi() {
		System.out.println("Registar zadataka: ");
		
		for (RadniZadatak z : this.zadaci) {
			z.ispisi();
		}
		
	}
	
}
