import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;


public class Tests {
	public static ArrayList<Gafas> lista = new ArrayList<Gafas>();
	
	// este test comprueba que los id de pedidos siempre van a se unicos, ya que siempre que se utiliza un id, 
	//se inserta un pedido lo que hace que el metodo que cuenta los pedidos que hay en la base, que es el numero 
	// que se utiliza como id de pedidos aumenta en el numero de gafas que tiene el pedido insertado.
	@Test
	public void test() {
		
		
		try {
			BD2.crearTablas(BD2.initBD("tiendabd"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gafas s = new Gafas( new JLabelGraficoAjustado("gafas.png", 200,100),"1","Phoebe","negro","Ray-Ban",false,23,89.99,"Las gafas perfectas para la vida");
		
		
		lista.add(s);
		lista.add(s);
		lista.add(s);
		
		int n = BD2.numeropedidos(BD2.initBD("tiendabd"));
		
		
		Pedido pedido = new Pedido(lista,"usuario");
		// TODO Auto-generated method stub
		
		BD2.insertarpedido(BD2.initBD("tiendabd"), pedido, pedido.nick);
		
		Assert.assertEquals(n+lista.size(),BD2.numeropedidos(BD2.initBD("tiendabd")),0);
		
		}

}
