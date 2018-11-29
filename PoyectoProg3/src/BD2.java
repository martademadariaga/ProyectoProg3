
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

			log(Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e);
			e.printStackTrace();
			return null;
		}
	}

	public static void crearTablas(Connection con) throws SQLException {
		try {
			Statement st = con.createStatement();
			st.setQueryTimeout(30);

			st.executeUpdate("CREATE TABLE if not exists usuario (nick varchar(35) NOT NULL ," + "ntar number(20),"
					+ "pass varchar(18))");

			st.executeUpdate(
					"CREATE TABLE if not exists pedido" + "(fecha date NOT NULL, " + "id_gafas number(9) not null , "
							+ "id  number(9) not null, " + "nick varchar(35) references usuario(nick))");

			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.log(Level.SEVERE, "Hubo un error en la creación de tablas", e);
		}

	}

	public static void insertarusuario(Connection con, String pass, String nick) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg

			statement
					.executeUpdate("insert into usuario (nick, pass) values(" + "'" + nick + "', " + "'" + pass + "')");

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection con = initBD("bdtienda");
			crearTablas(con);

			insertarusuario(con, "1234", "marta");

			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			String contraseña = "";
			String usuario = "";
			String ntar = "";

			;
			ResultSet rs = statement.executeQuery("select nick, pass, ntar from usuario");

			while (rs.next()) {

				String ID = rs.getString("nick");
				System.out.println("ID = " + ID);

				String CONT = rs.getString("pass");
				System.out.println("contraseña =" + CONT);
			}

			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
