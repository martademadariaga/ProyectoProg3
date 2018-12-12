import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	
	protected String nick;
	protected String contra;
	protected String nTar;
	protected HashMap<String, Pedido> pedidos;
	
	public Usuario(String nick, String email, String nTar, HashMap<String, Pedido> pedidos) {
		super();
		this.nick = nick;
		this.contra = email;
		this.nTar = nTar;
		this.pedidos = pedidos;
	}


	public Usuario() {
		super();
		this.nick = "null";
		this.contra = "null";
		this.nTar = "null";
		this.pedidos =  new HashMap<String, Pedido>();
	}
	
	
	
	
	

	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getEmail() {
		return contra;
	}


	public void setEmail(String email) {
		this.contra = email;
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
		return "Usuario [nick=" + nick + ", email=" + contra + ", nTar=" + nTar + ", pedidos=" + pedidos + "]";
	}

}
