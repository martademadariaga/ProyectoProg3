
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD2 {
	static Logger log;

	public static Connection initBD(String nombreBD) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			log(Level.INFO, "Conectada base de datos " + nombreBD, null);
			return con;
		} catch (ClassNotFoundException | SQLException e) {

			log(Level.SEVERE, "Error en conexiÃ³n de base de datos " + nombreBD, e);
			e.printStackTrace();
			return null;
		}
	}

	public static void crearTablas(Connection con) throws SQLException {
		try {
			Statement st = con.createStatement();
			st.setQueryTimeout(30);

			st.executeUpdate("CREATE TABLE if not exists usuario (nick varchar(35) NOT NULL ," + "email number(20),"
					+ "pass varchar(18))");

			st.executeUpdate(
					"CREATE TABLE if not exists pedido" + "(fecha varchar(10) NOT NULL, " + "id_gafas number(9) not null , "
							+ "id  varchar(9) not null, " + "nick varchar(35) references usuario(nick))");

			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "Hubo un error en la creaciÃ³n de tablas", e);
		}

	}

	public static void insertarusuario(Connection con, String pass, String nick) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

			statement.executeUpdate("insert into usuario (nick, pass) values(" + "'" + nick + "', " + "'" + pass + "')");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean usuarioenuso(Connection con, String nick) {
		boolean entrar = true;

		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

			ResultSet rs =statement.executeQuery("select * from usuario where nick='"+nick+"'");

			while(rs.next()) {
				if(rs.getString("nick").equals(nick)) {
					entrar = false;
					break;
				}else {
					entrar = true;
				}
			}
			
			statement.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return entrar;
			
		}


	public static boolean comprobarusuario(Connection con, String pass, String nick) {
		boolean entrar = false;
		String contrasen = "";
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

				 ResultSet rs =statement.executeQuery("select pass from usuario WHERE nick ='"+nick+"'");

		        while (rs.next()) {
		        String  contrasena = rs.getString("pass");
		          
		           if(contrasena.equals(pass)) {
					   entrar=true;
					
				   }else {
					   entrar= false;
					 
				   }
		        }
		        
		  
		
		
		        
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entrar;
		
	}
	
	public static boolean tieneEmail(Connection con, Usuario usuario) {
		boolean tiene= false;
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

				 ResultSet rs =statement.executeQuery("select email from usuario WHERE nick ='"+usuario.nick+"'");

		        while (rs.next()) {
		        if(!(rs.getString("email")== null)) {
		        tiene = true;
		        usuario.email = rs.getString("email");
		        }
		        }
		        
		   
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tiene;
		
	}
	public static void insertarEmail(Connection con, Usuario usuario) {

		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

				statement.executeUpdate("update usuario set email ='"+usuario.email+"' where nick = '"+usuario.nick+"'");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static int numeropedidos(Connection con) {
		int cont = 0;
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

				 ResultSet rs =statement.executeQuery("select * from pedido");

		        while (rs.next()) {
		            cont++;
		        }
		        
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cont;
	}
	
	
	
	public static void insertarpedido(Connection con, Pedido pedido, String nick) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

			for (int i = 0; i < pedido.gafasCompr.size(); i++) {
			
					statement.executeUpdate("insert into pedido values('"+pedido.fecha+"','"+pedido.gafasCompr.get(i).ident+"','"+i+""+pedido.id + "','"+nick +"')");
			}
		

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static Usuario verpedidos(Connection con,Usuario usuario) {
		Gafas s = null;
		ArrayList<String> ides = new ArrayList<String>();
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

				
			ResultSet rs=statement.executeQuery("select * from pedido where nick = '"+usuario.nick+"'");
			
			
			while (rs.next()) {
				String id = rs.getString("id");
				String idgafas = rs.getString("id_gafas");
				String fecha = rs.getString("fecha");
				
				String idd= id.substring(1);
				
				for (int i = 0; i < GestionTienda.gafasDisp.size(); i++) {
					if (GestionTienda.gafasDisp.get(i).ident.equals(idgafas)) {
						s = GestionTienda.gafasDisp.get(i);
						break;
					}
				}
				
				if(!usuario.pedidos.containsKey(idd)) {
					
					usuario.pedidos.put(idd, new Pedido(new ArrayList<Gafas>(), fecha, Integer.parseInt(idd), usuario.nick));
					usuario.pedidos.get(idd).gafasCompr.add(s);
					ides.add(idd);
					
				}else if (usuario.pedidos.containsKey(idd)&&ides.contains(idd)) {
					usuario.pedidos.get(idd).gafasCompr.add(s);
				}
			}
		

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		try {
//			Connection con = initBD("bdtienda");
//			crearTablas(con);
//
////			insertarusuario(con, "1234", "marta");
//
//			Statement statement = con.createStatement();
//			statement.setQueryTimeout(30); // poner timeout 30 msg
//			String contrasena = "";
//			String usuario = "";
//			String ntar = "";
//
//			;
//			ResultSet rs = statement.executeQuery("select nick, pass from usuario");
//			System.out.println(comprobarusuario(con,"",""));
//
//			while (rs.next()) {
//
//				String ID = rs.getString("nick");
//				System.out.println("ID = " + ID);
//
//				String CONT = rs.getString("pass");
//				System.out.println("contrasena =" + CONT);
//			}
//
//			statement.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static void log(Level level, String msg, Throwable excepcion) {
		if (log == null) { // Logger por defecto local:
			log = Logger.getLogger(BD2.class.getName());
			log.setLevel(Level.FINEST);
			try {
				Handler h = new FileHandler("bdtiendagafas.log.xml", true);
				h.setLevel(Level.FINEST);
				log.addHandler(h); // Y saca el log a fichero xml
			} catch (Exception e) {
				log.log(Level.WARNING, "No se pudo crear fichero de log", e);
			}
		}
		if (excepcion == null)
			log.log(level, msg);
		else
			log.log(level, msg, excepcion);
	}
	

}
