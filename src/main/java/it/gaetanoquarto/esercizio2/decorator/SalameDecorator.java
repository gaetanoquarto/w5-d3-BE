package it.gaetanoquarto.esercizio2.decorator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.gaetanoquarto.esercizio2.beans.Pizza;
import it.gaetanoquarto.esercizio2.beans.Topping;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Component
@Scope("prototype")
public class SalameDecorator extends Topping{

	public SalameDecorator(Pizza pizza) {
		
		this.pizza = pizza;
		this.nomeTopping = "salame";
		this.calorie = 110;
		this.prezzo = 0.15;

	}
	

	@Override
	public String getNome() {
		return pizza.getNome() + "salame ";
	}
	
	@Override
	public double getPrezzo() {
		return pizza.getPrezzo() + prezzo;
	}

	@Override
	public int getCalorie() {
		return pizza.getCalorie() + calorie;
	}
	
}
