package it.gaetanoquarto.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.gaetanoquarto.esercizio2.beans.Bevanda;
import it.gaetanoquarto.esercizio2.beans.Franchising;
import it.gaetanoquarto.esercizio2.beans.Ordine;
import it.gaetanoquarto.esercizio2.beans.Pizza;
import it.gaetanoquarto.esercizio2.beans.Prodotto;
import it.gaetanoquarto.esercizio2.beans.Stato;
import it.gaetanoquarto.esercizio2.beans.StatoOrdine;
import it.gaetanoquarto.esercizio2.beans.Tavolo;
import it.gaetanoquarto.esercizio2.beans.Topping;
import it.gaetanoquarto.esercizio2.decorator.AnanasDecorator;
import it.gaetanoquarto.esercizio2.decorator.MozzarellaDecorator;
import it.gaetanoquarto.esercizio2.decorator.PomodoroDecorator;
import it.gaetanoquarto.esercizio2.decorator.ProsciuttoDecorator;
import it.gaetanoquarto.esercizio2.decorator.SalameDecorator;

@SpringBootApplication
public class Week5Day1BeApplication {
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		SpringApplication.run(Week5Day1BeApplication.class, args);

		pizzeria();

	}
	
	
	public static void pizzeria() {
		
		ctx.scan("it.gaetanoquarto.esercizio2.beans");
		ctx.refresh();

		
		
		Pizza p1 =(Pizza) ctx.getBean(Pizza.class);
		Topping pMargherita = new PomodoroDecorator(new MozzarellaDecorator(p1));
		Topping pProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(p1)));
		Topping pAnanas = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new AnanasDecorator(p1))));
		Topping pSalameProsciutto = new PomodoroDecorator(new MozzarellaDecorator(new ProsciuttoDecorator(new SalameDecorator(p1))));
		Topping pSalame = new PomodoroDecorator(new MozzarellaDecorator(new SalameDecorator(p1)));
		
		Bevanda b1 = new Bevanda(1.29, "Limonata(0,33cl)", 128);
		Bevanda b2 = new Bevanda(1.29, "Acqua(0.5l)", 0);
		Bevanda b3 = new Bevanda(7.49, "Vino(0,75l, 13%)", 607);
		
		Franchising f1 = new Franchising("Maglia", 21.99);
		Franchising f2 = new Franchising("Tazza", 4.99);
		
		Topping mozzarella = new MozzarellaDecorator(p1);
		Topping pomodoro = new PomodoroDecorator(p1);
		Topping ananas = new AnanasDecorator(p1);
		Topping prosciutto = new ProsciuttoDecorator(p1);
		Topping salame = new SalameDecorator(p1);
		
		
		System.out.println("Benvenuti in Godfather's Pizza!");
		System.out.println("-------------------------------");
		System.out.println("---------PIZZE---------");
		System.out.println("Pizza Margherita " +"(" + pMargherita.getNome() + ")" + " | PREZZO: €" + pMargherita.getPrezzo() + " | CALORIE: " + pMargherita.getCalorie());
		System.out.println("Pizza Prosciutto " +"(" + pProsciutto.getNome() + ")" + " | PREZZO: €" + pProsciutto.getPrezzo() + " | CALORIE: " + pProsciutto.getCalorie());
		System.out.println("Pizza Hawaii " +"(" + pAnanas.getNome() + ")" + " | PREZZO: €" + pAnanas.getPrezzo() + " | CALORIE: " + pAnanas.getCalorie());
		System.out.println("Pizza Salame " +"(" + pSalame.getNome() + ")" + " | PREZZO: €" + pSalame.getPrezzo() + " | CALORIE: " + pSalame.getCalorie());
		System.out.println("Pizza Salame e prosciutto " +"(" + pSalameProsciutto.getNome() + ")" + " | PREZZO: €" + pSalameProsciutto.getPrezzo() + " | CALORIE: " + pSalameProsciutto.getCalorie());
		System.out.println("---------INGREDIENTI AGGIUNTIVI---------");
		System.out.println(mozzarella.getNomeTopping() + " | PREZZO: €" + mozzarella.getToppingPrezzo());
		System.out.println(pomodoro.getNomeTopping() + " | PREZZO: €" + pomodoro.getToppingPrezzo());
		System.out.println(prosciutto.getNomeTopping() + " | PREZZO: €" + prosciutto.getToppingPrezzo());
		System.out.println(salame.getNomeTopping() + " | PREZZO: €" + salame.getToppingPrezzo());
		System.out.println(ananas.getNomeTopping() + " | PREZZO: €" + ananas.getToppingPrezzo());
		System.out.println("---------BEVANDE---------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println("---------FRANCHISING---------");
		System.out.println(f1);
		System.out.println(f2);
		
				

		Tavolo tavolo1 = (Tavolo) ctx.getBean("tavolo", 1, 4, Stato.OCCUPATO);
		 List<Prodotto> list = new ArrayList<Prodotto>() {{
			add(pSalame);
			add(pProsciutto);
			add(pAnanas);
			add(pMargherita);
			add(b1);
			add(b3);
			add(b3);
			add(b2);
		}};

		gestioneOrdini(tavolo1, list);
		ctx.close();


	}

		public static void gestioneOrdini(Tavolo t, List<Prodotto> l) {
			Ordine ordine1 = (Ordine) ctx.getBean("ordine", t, 1, StatoOrdine.INCORSO, 4,21, l);
			ordine1.getTotale();
			System.out.println("----------------");
			ordine1.getListaOrdine();;
			System.out.println(ordine1);

		}

}

