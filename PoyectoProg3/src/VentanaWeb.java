import java.awt.Color;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Session;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

public class VentanaWeb extends JFrame {
	public static ArrayList<Gafas> lista = new ArrayList<Gafas>();
	public static DefaultListModel<ImageIcon> model = new DefaultListModel<ImageIcon>();
	public Container cp;
	public static JLabel p1;
	public static JLabel p2;
	public static JLabel p3;
	public JLabel labelu;
	public static JLabel fondo;
	public JLabel labelc;
	public JButton p4,reg,ini,siguiente, continuar;
	public static JButton comprar, borrar;
	public static JButton pedidos;
	public JTextField usu;
	public JPasswordField cont;
	public static JPanel regpan, webpan, inicio, tablagaf, listpan;
	public static JScrollPane panelgafas;
	public static JTable tablagafas;
	public static Connection con;
	public boolean entrar= false;
	public boolean regist;
	public static Usuario usuario;
	public static JComboBox combo;
	static int x;
	static int y;

	
	public static double redimx(double s) {
		s = (s/1920)*x;
		return s;
	}
	public static double redimy(double s) {
		s = (s/1080)*y;
		return s;
	}
	public static ImageIcon resize(String ImagePath,int w, int h){
		ImageIcon MyImage = new ImageIcon(ImagePath);
		
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(w,h, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;

	}
		// redimensionamos el frame
	

	public VentanaWeb() {
		// especificaciones
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		x=screenSize.width;
		y=screenSize.height;
		
		con=BD2.initBD("tiendabd");
		try {
			BD2.crearTablas(con);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		//cp

		cp = this.getContentPane();
		cp.setLayout(null);

		//JPanel inicio y web




		inicio= new JPanel();
		cp.add(inicio);
		inicio.setBounds( 0, 0,this.getWidth(), this.getHeight());
		inicio.setLayout(null);


		webpan= new JPanel();
		inicio.add(webpan);
		webpan.setBounds((int) redimx(400), (int)redimy(100),(int)redimx(1400),(int)(this.getHeight()-redimy(200)));
		webpan.setLayout(null);
		crearweb();
		webpan.setVisible(false);
		webpan.setBackground(ColorUIResource.BLUE);
		fondo= new JLabel(resize("compra.jpg",(int) redimx(500),(int)redimy(1721)));
		webpan.add(fondo);
		fondo.setBounds((int)redimx(900), 0,(int) redimx(500),(int)( this.getHeight()-redimy(300)));


		// botones registro

		p4= new JButton("");
		p4.setIcon(resize("empezar.jpg",(int)redimx(500),(int)redimy( 200)));
		p4.setBounds((int)redimx(150), (int)redimy(150),(int)redimx(500),(int)redimy( 200));
		inicio.add(p4);

		p4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				p4.setVisible(false);


			}

		});

		// registro o inicio de sesion
		reg= new JButton("");
		reg.setIcon(resize("reg.jpg",(int)redimx(500),(int)redimy(100)));
		reg.setBounds((int)redimx(150), (int)redimy(150),(int)redimx(500),(int)redimy(100));
		inicio.add(reg);
		reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reg.setVisible(false);
				ini.setVisible(false); 
				regist= true;


			}

		});


		ini= new JButton("");
		ini.setIcon(resize("ini.jpg",(int)redimx(500),(int)redimy(100)));
		ini.setBounds((int)redimx(150), (int)redimy(250),(int)redimx(500),(int)redimy(100));
		inicio.add(ini);

		ini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reg.setVisible(false);
				ini.setVisible(false); 
				regist = false;

			}

		});



		// panel de registro regpan
		regpan= new JPanel();
		inicio.add(regpan);
		regpan.setBackground(Color.WHITE);
		regpan.setBounds((int)redimx(150), (int)redimy(150),(int)redimx(500),(int)redimy( 200));
		regpan.setLayout(null);


		labelu= new JLabel(resize("inises.jpeg",(int)redimx(500),(int)redimy( 200)));
		labelu.setBounds((int)redimx(0), (int)redimy(0),(int)redimx(500),(int)redimy( 200));

		usu = new JTextField();
		usu.setBounds((int)redimx(250), (int)redimy(25),(int)redimx(200),(int)redimy(30));

		cont = new JPasswordField();
		cont.setBounds((int)redimx(250), (int)redimy(88),(int)redimx(200),(int)redimy( 30));

		continuar = new JButton("");
		continuar.setIcon(resize("continuar.jpeg",(int)redimx(200),(int)redimy(30)));
		continuar.setBounds((int)redimx(150), (int)redimy(150),(int)redimx(200),(int)redimy(30));


		regpan.add(usu);
		regpan.add(cont);
		regpan.add(continuar);
		regpan.add(labelu);


		continuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String nick = usu.getText();
				char[] contr = cont.getPassword();
				String contrasena = "";
				for (int i = 0; i < contr.length; i++) {
					contrasena = contrasena+contr[i];
				}
				
				if (regist) {
					entrar = BD2.usuarioenuso(con, nick);
					if (entrar) {
						BD2.insertarusuario(con, contrasena , nick);
					}
				}else {
					
					entrar = BD2.comprobarusuario(con, contrasena, nick );
				
				}
				
				if(entrar) {
				usuario = new Usuario(nick, contrasena,"",new HashMap<String, Pedido>());
				inicio.remove(regpan);
				webpan.setVisible(true);
				}


			}

		});


		// fotos del inicio
		p1 =new JLabel();
		inicio.add(p1);
		p2= new JLabel();
		inicio.add(p2);
		p3= new JLabel();
		inicio.add(p3);
		transicion(p1,p2,p3,inicio);



	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new VentanaWeb();
	}

	public static void transicion(JLabel l, JLabel k, JLabel m, JPanel f) {
		
		l.setIcon(resize("persona1.jpg",(int)redimx(2500),(int)redimy(1667)));
		k.setIcon(resize("persona2.jpg",(int)redimx(2500),(int)redimy(1667)));
		m.setIcon(resize("persona3.jpg",(int)redimx(3000),(int)redimy(1685)));
		l.setSize(f.getSize());
		m.setSize(f.getSize());
		k.setSize(f.getSize());
		l.setLocation(0,0);
		k.setLocation(-f.getWidth(),0);
		m.setLocation(-2*f.getWidth(),0);
		Thread t= new Thread() {

			public void run() {
				try {

					Thread.sleep(1000);
				} catch (InterruptedException ex) {

				}
				while(1!=2) {
					if(k.getX()>= f.getWidth()) {
						k.setLocation(-2*f.getWidth(),0);
						try {

							Thread.sleep(2000);
						} catch (InterruptedException ex) {

						}

					}if(m.getX()>= f.getWidth()) {
						m.setLocation(-2*f.getWidth(),0);
						try {

							Thread.sleep(2000);
						} catch (InterruptedException ex) {

						}

					}if(l.getX()>= f.getWidth()) {
						l.setLocation(-2*f.getWidth(),0);
						try {

							Thread.sleep(2000);
						} catch (InterruptedException ex) {

						}
					}
					k.setLocation(k.getX()+3,0);
					l.setLocation(l.getX()+3,0);
					m.setLocation(m.getX()+3,0);


					try {

						Thread.sleep(5);
					} catch (InterruptedException ex) {

					}

				}

			}

		};
		t.start();
	}

	public static void crearweb() {

		// web


		tablagaf= new TableIcon();
		tablagaf.setLayout(new GridLayout(1,1));


		listpan = new Tablapedido();
		listpan.setLayout(new GridLayout(1,1));


		webpan.add(listpan);
		webpan.add(tablagaf);

		//



		// panel de la tabla de gafas
		p1 =new JLabel();
		webpan.add(p1);
		p2= new JLabel();
		webpan.add(p2);
		p3= new JLabel();
		webpan.add(p3);
		// TODO 
		//transicion(p1,p2,p3,webpan);

		tablagaf.setBounds((int)redimx(0), (int)redimy(100),(int)redimx(900), (int) (webpan.getHeight()-redimy(100)));


		// panel de la lista del carrito

		listpan.setBounds((int)redimx(900), (int)redimy(100),(int)redimx(500),(int) (webpan.getHeight()-redimy(200)));
		listpan.setVisible(false);

		
		comprar = new JButton(resize("comprar.jpg",(int)redimx(500),(int)redimy(100)));
		comprar.setBounds((int)redimx(900), (int) (webpan.getHeight()-redimy(100)),(int)redimx(500),(int)redimy(100));

		webpan.add(comprar);
		comprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pedido pedido = new Pedido(lista,usuario.nick);
				// TODO Auto-generated method stub
				BD2.insertarpedido(con, pedido, pedido.nick);
				lista.clear();
				actualizarlista();
				
			}
			
		});
		
		
		pedidos = new JButton(resize("pedidos.jpg",(int)redimx(400),(int)redimy( 100)));
		pedidos.setBounds((int)redimx(900), (int)redimy(0),(int)redimx(400),(int)redimy( 100));
		webpan.add(pedidos);
		
		pedidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				usuario=BD2.verpedidos(con, usuario);
				String mensaje ="";
				
				
				Iterator<String> it = usuario.pedidos.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					
					mensaje = mensaje + usuario.nick+" hizo un pedido el dia "+usuario.pedidos.get(key).fecha+" de "+usuario.pedidos.get(key).gafasCompr.size()+ " gafas:\n";
					for (int i = 0; i <usuario.pedidos.get(key).gafasCompr.size(); i++) {
						mensaje = mensaje+ usuario.pedidos.get(key).gafasCompr.get(i).nombre+"\n";
					}
					
					
				}
				
				if(BD2.tieneEmail(con, usuario)) {
					new MailSender(usuario.email,mensaje);
					
				}else {
					String email = JOptionPane.showInputDialog( pedidos, "Introduce tu email:", "ENVIAR PEDIDOS", JOptionPane.QUESTION_MESSAGE );
					usuario.email= email;
					BD2.insertarEmail(con, usuario);
					new MailSender(usuario.email,mensaje);
					
				}
				
				
				
			}
			
		});
		
		
		borrar = new JButton(resize("papelera.jpg",(int)redimx(100),(int)redimy(100)));
		borrar.setBounds((int)redimx(1300), (int)redimy(0),(int)redimx(100),(int)redimy(100));
		webpan.add(borrar);
	
		
		borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Tablapedido.table.getSelectedRow()>-1) {
					lista.remove(Tablapedido.table.getSelectedRow());
					actualizarlista();
				}
			}
			
		});
		
		combo = new JComboBox<JLabel>();
		combo.setBounds((int)redimx(590), (int)redimy(0),(int)redimx(310),(int)redimy(100));
		webpan.add(combo);
		
		
		combo.addItem(new JLabel(new ImageIcon("amarillo.jpg")));
		combo.add(new JLabel(new ImageIcon("verde.jpg")));
		combo.add(new JLabel(new ImageIcon("rosa.jpg")));
		combo.add(new JLabel(new ImageIcon("rojo.jpg")));
		combo.add(new JLabel(new ImageIcon("azul.jpg")));
		combo.add(new JLabel(new ImageIcon("negro.jpg")));
		

	}

	
	
	public static void actualizarlista() {

		int n =0;

		if (lista.size()==0) {
			n =(0);
		} else if (lista.size()==1) {
			n =(200);
		} else if (lista.size()==2) {
			n =(400);
		} else if (lista.size()==3) {
			n = 600;
		} else {
			n =  webpan.getHeight()-(200);
		}

		webpan.remove(fondo);
		webpan.remove(listpan);
		listpan= new Tablapedido();
		listpan.setBounds((int)redimx(900), (int)redimy(100),(int)redimx(500),(int)redimy( n));
		listpan.setLayout(new GridLayout(1,1));
		listpan.setBackground(Color.blue);
		webpan.add(listpan);
		webpan.add(fondo);
		webpan.validate();
		webpan.repaint();

		listpan.setBackground(new Color(0,0,0,64));

	}
	
	
	
	

}
