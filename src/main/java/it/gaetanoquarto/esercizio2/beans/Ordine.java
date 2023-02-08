package it.gaetanoquarto.esercizio2.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@Scope("prototype")
public class Ordine{
	
	Tavolo tavolo;
	int nOrdine;
	StatoOrdine statoOrdine;
	int nCoperti;
	int oraOrdine;
	double importoTotale = 0;
	List<Prodotto> lista;
	Prodotto prodotto;
	Ordine ordine;
	
	public Ordine(Tavolo tavolo, int nOrdine, StatoOrdine statoOrdine, int nCoperti, int oraOrdine,
			List<Prodotto> lista) {
		this.tavolo = tavolo;
		this.nOrdine = nOrdine;
		this.statoOrdine = statoOrdine;
		this.nCoperti = nCoperti;
		this.oraOrdine = oraOrdine;
		this.lista = lista;
	}
	
	public void getTotale() {
		for(int i = 0; i < lista.size(); i++) {
			importoTotale += lista.get(i).prezzo;
		}
		importoTotale = importoTotale + (nCoperti * 2);
	}
	
	public void getListaOrdine() {
		System.out.println("--STAMPA SCONTRINO---");
		for(int i = 0; i < lista.size(); i ++) {
			System.out.println(lista.get(i).getNome() + " | PREZZO: " + lista.get(i).getPrezzo());
		}
	}

	@Override
	public String toString() {
		return "Ordine n. " + nOrdine + " | prezzo totale per " + nCoperti + " persone: " + importoTotale + "€";
	}
	

	
	
	
	
}
