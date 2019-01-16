import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	
	protected String nick;
	protected String email;
	protected String nTar;
	protected HashMap<String, Pedido> pedidos;
	
	public Usuario(String nick, String email, String nTar, HashMap<String, Pedido> pedidos) {
		super();
		this.nick = nick;
		this.email = email;
		this.nTar = nTar;
		this.pedidos = pedidos;
	}


	public Usuario() {
		super();
		this.nick = "";
		this.email = "";
		this.nTar = "";
		this.pedidos =  new HashMap<String, Pedido>();
	}
	
	
	
	
	

	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getnTar() {
		return nTar;
	}


	public void setnTar(String nTar) {
		this.nTar = nTar;
	}


	public HashMap<String, Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(HashMap<String, Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", email=" + email + ", nTar=" + nTar + ", pedidos=" + pedidos + "]";
	}

}
