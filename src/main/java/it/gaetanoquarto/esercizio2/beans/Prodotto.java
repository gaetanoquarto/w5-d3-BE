package it.gaetanoquarto.esercizio2.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@Scope("prototype")
public abstract class Prodotto {
	
	double prezzo;
	String nome;
	int calorie;

}
