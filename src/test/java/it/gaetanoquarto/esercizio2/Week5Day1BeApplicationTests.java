package it.gaetanoquarto.esercizio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.gaetanoquarto.esercizio2.beans.Pizza;
import it.gaetanoquarto.esercizio2.beans.Prodotto;
import it.gaetanoquarto.esercizio2.beans.Topping;
import it.gaetanoquarto.esercizio2.decorator.MozzarellaDecorator;
import it.gaetanoquarto.esercizio2.decorator.PomodoroDecorator;

@SpringBootTest
class Week5Day1BeApplicationTests {
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();


	@Test
	void testAddOneItem() {

		ctx.scan("it.gaetanoquarto.esercizio2.beans");
		ctx.refresh();
		
		Pizza p1 =(Pizza) ctx.getBean(Pizza.class);
		Topping pMargherita = new PomodoroDecorator(new MozzarellaDecorator(p1));
		 List<Prodotto> list = new ArrayList<Prodotto>() {{
				add(pMargherita);
			}};

		assertEquals(list.size(), 1);
		
		ctx.close();


	}

}
