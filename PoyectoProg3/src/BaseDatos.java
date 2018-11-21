import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPasswordField;
import javax.swing.JTextField;



import java.sql.SQLException;
import java.sql.ResultSet;

public class BaseDatos {

	 static Logger log;
	
	
	public static void cargarBD(String nombreBD) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		JPasswordField p = new JPasswordField(18);
		JTextField u = new JTextField(18);
		char[] pass = p.getPassword();
		String user = u.getText();
		Class.forName("org.sqlite.JBDC" + nombreBD);

		Connection con = null;
		try {
			log.log(Level.INFO, "Conectándose a la BBDD seleccionada");
			con = DriverManager.getConnection("jdbc:sqlite:tienda.db", user, pass.toString());

			if (user.equals("amere") && pass.equals("tienda0"))
				log.log(Level.INFO, "Conexión establecida con BBDD " + nombreBD);
			else {
				log.log(Level.INFO, "Usuario y/o contraseña incorrectos, intenta de nuevo");

				Statement st = con.createStatement();
				st.setQueryTimeout(40);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "Error en la conexión", e);
		}
	}

	public static Statement crearTablas(Connection con) throws SQLException {
			try {
				Statement st = con.createStatement();
				st.setQueryTimeout(40);
				try {
				st.executeUpdate("create table usuario"+
						"(dni not null number(9), "+
						"email varchar(35),"+
						"ntar number(20),"+
						"pass varchar(18)"+
						"primary key(dni))");
			
				
			}catch(SQLException e) { //Tabla ya creada, no se hace nada
			}
			
			try {	st.executeUpdate("create table pedido"+
						"(dni not null number(9), "+
						"fecha date not null, "+
						"id_gafas not null number(9), "+
						"id not null number(9), "+
						"primary key(id), "+
						"foreign key dni references usuario(dni))");
				
			}catch(SQLException e) {}
			log.log(Level.INFO, "Tablas creadas con éxito");
			return st;
			}catch(SQLException e1) {
				e1.printStackTrace();
				log.log(Level.SEVERE, "Hubo un error en la creación de tablas", e1);
			}
			return null;
		
	}
	
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (log==null) {  // Logger por defecto local:
			log = Logger.getLogger( BaseDatos.class.getName() );  
			log.setLevel( Level.FINEST ); 
			try {
				Handler h= new FileHandler( "bdtiendagafas.log.xml", true );
				log.addHandler(h);  // Y saca el log a fichero xml
			} catch (Exception e) {
				log.log( Level.WARNING, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			log.log( level, msg );
		else
			log.log( level, msg, excepcion );
	}


public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			log.log(Level.INFO, "Cerrando la base de datos");
		} catch (SQLException e) {
			log.log(Level.SEVERE, "Error al cerrar la base de datos", e);
			e.printStackTrace();
		}
	}

}
