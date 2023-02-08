package it.gaetanoquarto.esercizio2.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
public class Tavolo{
	private int numero;
	private int nPosti;
	private Stato stato;
	
}


