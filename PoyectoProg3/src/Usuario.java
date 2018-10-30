import java.util.ArrayList;

public class Usuario {
	
	protected String nick;

	protected String email;
	protected String nTar;
	protected ArrayList<Pedido> pedidos;
	
	public Usuario(String nick, String email, String nTar, ArrayList<Pedido> pedidos) {
		super();
		this.nick = nick;
		this.email = email;
		this.nTar = nTar;
		this.pedidos = pedidos;
	}


	public Usuario() {
		super();
		this.nick = "null";
		this.email = "null";
		this.nTar = "null";
		this.pedidos = new ArrayList<Pedido>();
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


	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", email=" + email + ", nTar=" + nTar + ", pedidos=" + pedidos + "]";
	}

}
