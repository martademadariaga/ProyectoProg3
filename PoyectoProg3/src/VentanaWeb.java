import java.awt.Color;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

public class VentanaWeb extends JFrame {
	public static ArrayList<Gafas> lista = new ArrayList<Gafas>();
	public static DefaultListModel<ImageIcon> model = new DefaultListModel<ImageIcon>();
	public static JList list= new JList();
	public Container cp;
	public static JLabel p1;
	public static JLabel p2;
	public static JLabel p3;
	public JLabel labelu;
	public static JLabel fondo;
	public JLabel labelc;
	public JButton p4,reg,ini,siguiente, continuar;
	public JTextField usu;
	public JPasswordField cont;
	public static JPanel regpan, webpan, inicio, tablagaf, listpan;
	public static JScrollPane panelgafas;
	public static JTable tablagafas;



	public VentanaWeb() {
		// especificaciones
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
		webpan.setBounds( 400, 200,1400, this.getHeight()-300);
		webpan.setLayout(null);
		crearweb();
		webpan.setVisible(false);
		webpan.setBackground(ColorUIResource.BLUE);
		fondo= new JLabel(new ImageIcon("compra.jpg"));
		webpan.add(fondo);
		fondo.setBounds(900, 0, 500, this.getHeight()-300);


		// botones registro

		p4= new JButton("");
		p4.setIcon(new ImageIcon("empezar.jpg"));
		p4.setBounds(150, 150, 500, 200);
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
		reg.setIcon(new ImageIcon("reg.jpg"));
		reg.setBounds(150, 150, 500, 100);
		inicio.add(reg);
		reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reg.setVisible(false);
				ini.setVisible(false); 
				registro();


			}

		});


		ini= new JButton("");
		ini.setIcon(new ImageIcon("ini.jpg"));
		ini.setBounds(150, 250, 500, 100);
		inicio.add(ini);

		ini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reg.setVisible(false);
				ini.setVisible(false); 
				iniciosesion();


			}

		});



		// panel de registro regpan
		regpan= new JPanel();
		inicio.add(regpan);
		regpan.setBackground(Color.WHITE);
		regpan.setBounds(150,150 , 500, 200);
		regpan.setLayout(null);


		labelu= new JLabel(new ImageIcon("inises.jpeg"));
		labelu.setBounds(0,0,500,200);

		usu = new JTextField();
		usu.setBounds(250,25,200,30);

		cont = new JPasswordField();
		cont.setBounds(250,88,200,30);

		continuar = new JButton("");
		continuar.setIcon(new ImageIcon("continuar.jpeg"));
		continuar.setBounds(150,150,200,30);


		regpan.add(usu);
		regpan.add(cont);
		regpan.add(continuar);
		regpan.add(labelu);


		continuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				inicio.remove(regpan);
				webpan.setVisible(true);


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
		l.setIcon(new ImageIcon("persona1.jpg"));
		k.setIcon(new ImageIcon("persona2.jpg"));
		m.setIcon(new ImageIcon("persona3.jpg"));
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
	public static void registro() {

		

	}
	public static void iniciosesion() {



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

		tablagaf.setBounds(0,0,900, webpan.getHeight());

		// panel de la lista del carrito

		listpan.setBounds(900,0,500, webpan.getHeight());
		listpan.setVisible(false);



	}
	public static void
	actualizarlista() {

		int n =0;

		if (lista.size()==0) {
			n = 0;
		} else if (lista.size()==1) {
			n = 200;
		} else if (lista.size()==2) {
			n = 400;
		} else if (lista.size()==3) {
			n = 600;
		} else {
			n =  webpan.getHeight();
		}

		webpan.remove(fondo);
		webpan.remove(listpan);
		listpan= new Tablapedido();
		listpan.setBounds(900,0,500, n);
		listpan.setLayout(new GridLayout(1,1));
		listpan.setBackground(Color.blue);
		webpan.add(listpan);
		webpan.add(fondo);
		webpan.validate();
		webpan.repaint();

		//listpan.setBackground(new Color(0,0,0,64));

	}

}
