import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	protected ArrayList<Gafas> gafasCompr;
	protected Date fCompr;
	
	
	
	
	

	public Pedido(ArrayList<Gafas> gafasCompr, Date fCompr) {
		super();
		this.gafasCompr = gafasCompr;
		this.fCompr = fCompr;
	}


	public Pedido() {
		super();
		this.gafasCompr = new ArrayList<Gafas>();
		this.fCompr = null;
	}





	public ArrayList<Gafas> getGafasCompr() {
		return gafasCompr;
	}


	public void setGafasCompr(ArrayList<Gafas> gafasCompr) {
		this.gafasCompr = gafasCompr;
	}


	public Date getfCompr() {
		return fCompr;
	}


	public void setfCompr(Date fCompr) {
		this.fCompr = fCompr;
	}


	@Override
	public String toString() {
		return "Pedido [gafasCompr=" + gafasCompr + ", fCompr=" + fCompr + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
