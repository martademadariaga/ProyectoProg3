import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaWeb extends JFrame {
	public Container cp;
	public JLabel p1;
	public JLabel p2;
	public JLabel p3;
	public JButton p4,reg, ini;
	
	public VentanaWeb() {
		// especificaciones
				this.setVisible(true);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//cp
		
		cp = this.getContentPane();
		cp.setLayout(null);
		
		// botones registro
		
		p4= new JButton("");
		p4.setIcon(new ImageIcon("empezar.png"));
		p4.setBounds(150, 150, 500, 200);
		cp.add(p4);
		
		p4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				p4.setVisible(false);
				
				
			}
			
		});
		
		// registro o inicio de sesion
		reg= new JButton("");
		reg.setIcon(new ImageIcon("empezar.png"));
		reg.setBounds(150, 150, 500, 100);
		cp.add(reg);
		ini= new JButton("");
		ini.setIcon(new ImageIcon("empezar.png"));
		ini.setBounds(150, 225, 500, 100);
		cp.add(ini);
		
		
		
		// fotos del inicio
		p1 =new JLabel();
		cp.add(p1);
		p1.setBounds(0,0,this.getWidth(), this.getHeight());
		p2= new JLabel();
		cp.add(p2);
		p3= new JLabel();
		cp.add(p3);
		transicion(p1,p2,p3,this);
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new VentanaWeb();
	}
	
	public static void transicion(JLabel l, JLabel k, JLabel m, JFrame f) {
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

	

}
