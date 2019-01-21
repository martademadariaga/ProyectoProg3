import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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
	public static JComboBox<String> combo,orden;
	static int x;
	static int y;
	public static double[] arr= new double[30];
	public static JLabel logo;
	public static JButton atras;
	public static JLabel ueu,une,ci,cnv;
	
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
		GestionTienda.crearGafas("archivogafas.txt");
	
		
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
		
		this.setIconImage(new ImageIcon("amere.png").getImage());
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
		
		ueu= new JLabel("usuario en uso");
		ueu.setBounds((int)redimx(250), (int)redimy(-30),(int)redimx(500),(int)redimy( 200));
		ueu.setForeground(Color.white);
		ueu.setVisible(false);
		
		une= new JLabel("usuario no existente");
		une.setBounds((int)redimx(250), (int)redimy(-30),(int)redimx(500),(int)redimy( 200));
		une.setForeground(Color.white);
		une.setVisible(false);
		
		cont = new JPasswordField();
		cont.setBounds((int)redimx(250), (int)redimy(88),(int)redimx(200),(int)redimy( 30));

		ci= new JLabel("contrasena incorrecta");
		ci.setBounds((int)redimx(250), (int)redimy(30),(int)redimx(500),(int)redimy( 200));
		ci.setForeground(Color.white);
		ci.setVisible(false);
		
		cnv= new JLabel("usuario o contrasena no validos");
		cnv.setBounds((int)redimx(250), (int)redimy(30),(int)redimx(500),(int)redimy( 200));
		cnv.setForeground(Color.white);
		cnv.setVisible(false);
		
		continuar = new JButton("");
		continuar.setIcon(resize("continuar.jpeg",(int)redimx(170),(int)redimy(30)));
		continuar.setBounds((int)redimx(180), (int)redimy(150),(int)redimx(170),(int)redimy(30));

		
		atras = new JButton("");
		atras.setIcon(resize("atras.jpg",(int)redimx(30),(int)redimy(30)));
		atras.setBounds((int)redimx(150), (int)redimy(150),(int)redimx(30),(int)redimy(30));
		atras.setBackground(Color.black);
		
		regpan.add(une);
		regpan.add(ueu);
		regpan.add(ci);
		regpan.add(cnv);
		regpan.add(atras);
		regpan.add(usu);
		regpan.add(cont);
		regpan.add(continuar);
		regpan.add(labelu);
		
		
	

		continuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ci.setVisible(false);
				cnv.setVisible(false);
				ueu.setVisible(false);
				une.setVisible(false);
				
				
				String nick = usu.getText();
				char[] contr = cont.getPassword();
				String contrasena = "";
				for (int i = 0; i < contr.length; i++) {
					contrasena = contrasena+contr[i];
				}
				if(nick.equals("")||contrasena.equals("")) {
					cnv.setVisible(true);
				}else {
				
				
				if (regist) {
					entrar = BD2.usuarioenuso(con, nick);
					if (entrar) {
						BD2.insertarusuario(con, contrasena , nick);
					}else {
						ueu.setVisible(true);
					}
				}else {
					
					entrar = BD2.comprobarusuario(con, contrasena, nick );
				
					if (!entrar) {
						boolean usuario = BD2.usuarioenuso(con, nick);
						if(usuario) {
							une.setVisible(true);
						}else {
							ci.setVisible(true);
						}
					
				}
				}
				if(entrar) {
				usuario = new Usuario(nick, contrasena,"",new HashMap<String, Pedido>());
				inicio.remove(regpan);
				webpan.setVisible(true);
				
				}

				}
			}

		});
		
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				reg.setVisible(true);
				ini.setVisible(true); 
				
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
		
		// este boton hace que se mande un mensaje al ususario con un registro de sus pedidos
		pedidos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				usuario=BD2.verpedidos(con, usuario);
				String mensaje ="Sus pedidos:\n";
				
				
				Iterator<String> it = usuario.pedidos.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					
					mensaje = mensaje + "Dia "+usuario.pedidos.get(key).fecha+", "+usuario.pedidos.get(key).gafasCompr.size()+ " gafas:\n";
					for (int i = 0; i <usuario.pedidos.get(key).gafasCompr.size(); i++) {
						mensaje = mensaje+ " "+usuario.pedidos.get(key).gafasCompr.get(i).nombre+"\n";
					}
					
					
				}
				
				if(BD2.tieneEmail(con, usuario)&& usuario.email.length()>4) {
					new MailSender(webpan, usuario.email,mensaje);
					
				}else {
					String email = JOptionPane.showInputDialog( pedidos, "Introduce tu email:", "ENVIAR PEDIDOS", JOptionPane.QUESTION_MESSAGE );
					usuario.email= email;
					BD2.insertarEmail(con, usuario);
					new MailSender(webpan, usuario.email,mensaje);
					
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
		
		
		// boton para filtrar por colores
		combo = new JComboBox<String>();
		combo.setBounds((int)redimx(590), (int)redimy(0),(int)redimx(310),(int)redimy(100));
		webpan.add(combo);
		
		combo.addItem("cero");
		combo.addItem("dos");
		combo.addItem("uno");
		combo.addItem("tres");
		combo.addItem("cuatro");
		combo.addItem("cinco");
		combo.addItem("seis");
		
		 combo.setRenderer(new RenderJCombobox());
	     combo.setSelectedIndex(0);
	     combo.setBackground(Color.white);
	   
	     
	     
	    combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GestionTienda.gafasDisp = new ArrayList<Gafas>();

				
				if (combo.getSelectedItem().equals("dos")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
						if(gafas.Colores.equals("verde")){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}else if (combo.getSelectedItem().equals("cero")){
							GestionTienda.gafasDisp=GestionTienda.gafasTienda;
				
				}else if (combo.getSelectedItem().equals("uno")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
			
						if(gafas.Colores.equals("amarillo")){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}else if (combo.getSelectedItem().equals("tres")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
					
						if(gafas.Colores.equals("rosa")){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}else if (combo.getSelectedItem().equals("cuatro")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
				
						if(gafas.Colores.equals("rojo")){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}else if (combo.getSelectedItem().equals("cinco")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
			
						if(gafas.Colores.equals("azul")){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}else if (combo.getSelectedItem().equals("seis")){
					for (Gafas gafas : GestionTienda.gafasTienda) {
			
						if(gafas.Colores.equals("negro")||gafas.Colores.equals("gris") ){
							GestionTienda.gafasDisp.add(gafas);
						}
					}
				
				}
				if (!GestionTienda.gafasDisp.isEmpty()) {
				actualizartabla();
				
				}else {
					GestionTienda.gafasDisp=GestionTienda.gafasTienda;
					JOptionPane.showMessageDialog(webpan,"No hay disponibles gafas de ese color");
				}
			}
	    	
	    });
	    
	    
	  
	    
	    // combobox para ordenar de forma recursiva
	    
	    orden = new JComboBox<String>();
		orden.setBounds((int)redimx(295), (int)redimy(0),(int)redimx(295),(int)redimy(100));
		webpan.add(orden);
		
		orden.addItem("ORDENAR...");
		orden.addItem("MENOR-MAYOR");
		orden.addItem("MAYOR-MENOR");
		orden.setBackground(Color.white);
		orden.setForeground(new Color(100, 37, 50));
		orden.setFont(new Font("SERIF",1, 30));
		
		orden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				arr = new double[GestionTienda.gafasDisp.size()];
				ArrayList<Gafas> gafasDispo = new ArrayList<Gafas>();
				gafasDispo = GestionTienda.gafasDisp;
				GestionTienda.gafasDisp = new ArrayList<Gafas>();
				
				
				  for (int i = 0; i <gafasDispo.size(); i++) {
					boolean repetido= false;
					for (int j = 0; j < arr.length; j++) {
						if (gafasDispo.get(i).precio== arr[j]) {
							repetido = true;
						}
					}
					if(!repetido) {
					arr[i]=gafasDispo.get(i).precio; 
					}
				  }
				  
				  ordenar(arr.length);
				  
				  if(orden.getSelectedItem().equals("MENOR-MAYOR")) {
					  for (int j = 0; j < arr.length; j++) {
						  for (Gafas gafas : gafasDispo) {
								
								if(gafas.precio== arr[j]){
									GestionTienda.gafasDisp.add(gafas);
									
									
								}
							}
					}
				  }else if(orden.getSelectedItem().equals("MAYOR-MENOR")) {
					  for (int j = arr.length-1; j >-1; j--) {
						  for (Gafas gafas :  gafasDispo) {
								
								if(gafas.precio== arr[j]){
									GestionTienda.gafasDisp.add(gafas);
								
								}
							}
					}  
					  
				  }else {
					  GestionTienda.gafasDisp=GestionTienda.gafasTienda;
				  }
				  
				actualizartabla();
			}
			
		});
		
		
		
		logo = new JLabel(new ImageIcon("amere.jpg"));
		logo.setBounds((int)redimx(0), (int)redimy(0),(int)redimx(295),(int)redimy(100));
		webpan.add(logo);
		
	}
	
	
	
	
	
	public static void ordenar(int n) {
		  if (n > 1)
			    ordenar(n-1);

			  int x = n-1;
			  double numero = arr[x];

			  while ((x>0) && (arr[x-1] > numero)) {
			    arr[x] = arr[x-1];
			    x--;
			  }
			  arr[x] = numero;
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
	
	public static void actualizartabla() {

		webpan.remove(tablagaf);
		tablagaf= new TableIcon();
		tablagaf.setBounds((int)redimx(0), (int)redimy(100),(int)redimx(900), (int) (webpan.getHeight()-redimy(100)));
		tablagaf.setLayout(new GridLayout(1,1));
		webpan.add(tablagaf);
		webpan.validate();
		webpan.repaint();

		
	}
	
	
	

}
