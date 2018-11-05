import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaWeb extends JFrame {
	public Container cp;
	public static JLabel p1;
	public static JLabel p2;
	public static JLabel p3;
	public JLabel labelu;
	public JLabel labelc;
	public JButton p4,reg,ini,siguiente, continuar;
	public JTextField usu;
	public JPasswordField cont;
	public static JPanel regpan, webpan, inicio, tablagaf;
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
		cp.add(webpan);
		webpan.setBounds( 0, 0,this.getWidth(), this.getHeight());
		webpan.setLayout(null);
		
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
		
		labelu= new JLabel("nombre de usuario");
		labelu.setBounds(0,50,200,30);
		labelc= new JLabel("contraseña");
		labelc.setBounds(0,100,200,30);
		usu = new JTextField();
		usu.setBounds(200,50,200,30);
		cont = new JPasswordField();
		cont.setBounds(200,100,200,30);
		
		continuar = new JButton("continuar");
		continuar.setBounds(150,150,200,30);
		
		regpan.add(labelu);
		regpan.add(labelc);
		regpan.add(usu);
		regpan.add(cont);
		regpan.add(continuar);
		
		
		
		continuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				inicio.removeAll();
				inicio.setVisible(false);
				crearweb();
				
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
		
//		GestionTienda.crearGafas("archivogafas.txt");
//		tablagafas = new JTable();
//		panelgafas = new JScrollPane(tablagafas);
//		tablagafas.setModel(new DefaultTableModel(10,3));
//		int cont= 0;
//		Gafas gafas;
//		for (int i = 0; i <10; i++) {
//			for (int j = 0; j < 3; j++) {
//				// JLabel prueba = new JLabel(new ImageIcon("gafas.png"));
//				ImageIcon icon = new ImageIcon("gafas.png");
//				tablagafas.setValueAt(icon, i, j);
//				tablagafas.setValueAt(GestionTienda.gafasDisp.get(cont).label.getIcon(), i, j);
//				cont++;
//			}
//		}
//		
//		panelgafas.getViewport().add(tablagafas);
//		webpan.add(tablagafas);
//		tablagafas.setBounds(500,0,1000,webpan.getHeight());
//		tablagafas.setRowHeight(200);
		
		tablagaf= new JPanel();
		tablagaf.setLayout(new GridLayout(1,1));
		tablagaf.setBackground(Color.red);
		webpan.add(tablagaf);
		webpan.setBackground(Color.GRAY);
		
		p1 =new JLabel();
		webpan.add(p1);
		p2= new JLabel();
		webpan.add(p2);
		p3= new JLabel();
		webpan.add(p3);
		transicion(p1,p2,p3,webpan);
		
		
		
		tablagaf.setBounds(500,200,1800, webpan.getHeight()-300);
		tablagaf.add(new TableIcon(tablagaf));
	
		
	}
	
	

}
