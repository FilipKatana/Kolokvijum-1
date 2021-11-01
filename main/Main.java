package main;

import java.util.ArrayList;

import ispis.Ispisivo;
import osoba.Osoba;
import registar.RegistarZadataka;
import uredjaj.Uredjaj;
import zadatak.Izvrsivo;
import zadatak.Nabavka;
import zadatak.Odrzavanje;
import zadatak.SlozeniZadatak;
import zadatak.StatusZadatka;

public class Main {


	
	public static void main(String[] args) {
		Osoba o1 = new Osoba("Sava", "Markiæ");
		
		Uredjaj u = new Uredjaj("Kompjuter", 600.7);
		
		Izvrsivo o2 = new Osoba("Mila", "Miliæ");
		
		Odrzavanje od = new Odrzavanje("Održavanje 1", "Popravljanje kom", o1, u, "Pokvario se CPU");
		
		Nabavka nb = new Nabavka("Nabavka 1", "Nabavka kompjutera", o1, o2, 20);
		
		RegistarZadataka registar = new RegistarZadataka(od);
		registar.dodaj(nb);
		

		ArrayList<Ispisivo> ispisi = new ArrayList<Ispisivo>();
		
		ispisi.add(o1);
		ispisi.add(u);
		ispisi.add(nb);
		ispisi.add(registar);
		
		for (Ispisivo x : ispisi) {
			x.ispisi();
			System.out.println("--------------");
		}
		
		System.out.println("==============================================");
		
		SlozeniZadatak slozeni = new SlozeniZadatak("Složen 1", "komplikovan", o1, o2, 
				new SlozeniZadatak("Složen 2", "jako težak", o1, o2, od, nb), nb);
		
		slozeni.ispisi(1);
		
	}
}
