import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class VentanaWeb2 extends JFrame {
	public Container cp;
	public JLabelGraficoAjustado p1,p2,p3;
	public JButton p4;
	
	public VentanaWeb2() {
		// especificaciones
				this.setVisible(true);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				this.setResizable(true);
		
		//cp
		
		cp = this.getContentPane();
		cp.setLayout(null);
		
		// fotos del inicio
		p4= new JButton("");
		p4.setIcon(new ImageIcon("empezar.png"));
		p4.setBounds(150, 150,this.getWidth()/4, this.getHeight()/5);
		cp.add(p4);
		
		p1 = new JLabelGraficoAjustado("persona1.jpg",this.getWidth(), this.getHeight());
		cp.add(p1);
		p1.setBounds(0,0,this.getWidth(), this.getHeight());
		p2= new JLabelGraficoAjustado("persona2.jpg",this.getWidth(), this.getHeight());
		cp.add(p2);
		p3 = new JLabelGraficoAjustado("persona3.jpg",this.getWidth(), this.getHeight());
		cp.add(p3);
		transicion(p1,p2,p3,this, p4);
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new VentanaWeb2();
	}
	
	public static void transicion(JLabelGraficoAjustado l, JLabelGraficoAjustado k, JLabelGraficoAjustado m, JFrame f, JButton b) {
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
					k.setLocation(k.getX()+9,0);
					l.setLocation(l.getX()+9,0);
					m.setLocation(m.getX()+9,0);
					
					
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
