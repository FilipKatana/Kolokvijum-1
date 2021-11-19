package main;

import java.util.ArrayList;

import ispis.Ispisivo;
import osoba.Osoba;
import registar.RegistarZadataka;
import uredjaj.Uredjaj;
import zadatak.Izvrsivo;
import zadatak.Nabavka;
import zadatak.Odrzavanje;
import zadatak.RadniZadatak;
import zadatak.SlozeniZadatak;
import zadatak.StatusZadatka;

public class Main {


	
	public static void main(String[] args) {
		Osoba o1 = new Osoba("Sava", "Markić");
		
		Uredjaj u = new Uredjaj("Kompjuter", 600.7);
		
		Izvrsivo o2 = new Osoba("Mila", "Miliž");
		
		Odrzavanje od = new Odrzavanje("Održavanje 1", "Popravljanje kom", u, "Pokvario se CPU");
		
		Nabavka nb = new Nabavka("Nabavka 1", "Nabavka kompjutera", o2, 20);
		
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
		
		SlozeniZadatak slozeni = new SlozeniZadatak("Složen 1", "komplikovan", o2, 
				new SlozeniZadatak("Složen 2", "jako težak", o2, od, nb), nb);
		
		slozeni.ispisi(1);
		
		System.out.println("##########MULTITHREAD##################");
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep((long) Math.random()*100);
						RadniZadatak rad = registar.zahtevaj(o1);
						Thread.sleep((long) Math.random()*100);
						if (rad.getStatus() == StatusZadatka.OTPOCET) {
							rad.setStatus((Math.random() <= 0.5) ? StatusZadatka.IZVRSEN : StatusZadatka.NEIZVRSEN);
							registar.dodajIzvrsen(rad);
						} else {
							rad.setStatus(StatusZadatka.OTPOCET);
							registar.dodaj(rad);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		
		Thread t1 = new Thread(run);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		registar.izvrseniPrint();
		
		
	}
}
