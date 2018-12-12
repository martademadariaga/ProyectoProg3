import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	protected ArrayList<Gafas> gafasCompr;
	protected String fecha;
	int id;
	String nick;
	
	

	public Pedido(ArrayList<Gafas> gafasCompr, String fecha, int id, String nick) {
		super();
		this.gafasCompr = gafasCompr;
		this.fecha = fecha;
		this.id = id;
		this.nick = nick;
	}
	
	public Pedido(ArrayList<Gafas> gafasCompr, String nick) {
		super();
		this.gafasCompr = gafasCompr;
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.fecha = dateFormat.format(date);
		this.id = BD2.numeropedidos(VentanaWeb.con);
		this.nick = nick;
	}


	public ArrayList<Gafas> getGafasCompr() {
		return gafasCompr;
	}


	public void setGafasCompr(ArrayList<Gafas> gafasCompr) {
		this.gafasCompr = gafasCompr;
	}


	public String getfecha() {
		return fecha;
	}


	public void setfecha(String fCompr) {
		this.fecha = fCompr;
	}


	@Override
	public String toString() {
		return "Pedido [gafasCompr=" + gafasCompr + ", fecha=" + fecha + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

