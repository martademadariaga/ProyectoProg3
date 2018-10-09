import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaGafa extends JFrame{

	

	 static boolean raton = false;
	 public Container cp;
	public static JLabelGraficoAjustado gafas;
	public JLabel label;
	public JPanel arriba;
	public JPanel abajo;
	public JPanel arribad;
	public JPanel abajoi;
	public JButton browse;
	public JSlider zoom;
	public JSlider rotar;
	public JTextField texto;

	public VentanaGafa(Gafas s) {
		cp = this.getContentPane();
		cp.setLayout(null);

		//panel de la foto
		arriba = new JPanel();
		arriba.setLayout(null);
		arriba.setBackground(Color.green);
		arriba.setBounds(0, 0, 940,380);
		cp.add(arriba);

		
		
		// panel browse
		abajo = new JPanel();
		abajo.setLayout(new GridLayout(2,1));
		cp.add(abajo);
		browse = new JButton("Browse");
		abajo.add(browse);
		abajo.setBounds(0, 380, 640,120);
	
	
		
		// gafas
		
		gafas = s.label;
		arriba.add(s.label);
		gafas.setLocation(690, 50);
		moverGafas(gafas, arriba);
	


		gafas.addMouseListener(new MouseListener()
		{
		public void mouseClicked(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
			raton = true;
		}
		public void mouseReleased(MouseEvent arg0) {
			raton = false;
		}
		});
		
		
		
		// controles de las gafas
		
				arribad = new JPanel();
				arribad.setBounds(640,0,300,480);
				arribad.setBackground(Color.white);
				arriba.add(arribad);
				

				zoom = new JSlider();
				zoom.setMaximum(300);
				zoom.setMinimum(25);
				zoom.setValue(100);
				arribad.add(zoom);
				zoom.setLocation(690, 50);
				zoom.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
					
					
					gafas.setSize(200*zoom.getValue()/100, 100*zoom.getValue()/100);
					}
					
				});
				
				rotar = new JSlider();
				rotar.setMaximum(180);
				rotar.setMinimum(-180);
				rotar.setValue(0);
				arribad.add(rotar);
				rotar.setLocation(690, 150);
				rotar.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
					
					
					gafas.setRotacion(Math.toRadians(rotar.getValue()));
					
					}
					
				});
				
				

		
		
		
		// pane de la foto
		
		label = new JLabel(new ImageIcon("predet.png"));
		arriba.add(label);
		
		label.setSize(640,380);
	
		

		browse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				//filter the files
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				//if the user click on save in Jfilechooser
				if(result == JFileChooser.APPROVE_OPTION){
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();

					label.setIcon(ResizeWindow(path));
					//label= new JLabel(new ImageIcon(path));
					arriba.add(label);
					cp.repaint();


				}else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("No File Select");
				}


			}

		});

	
		
		//abajo
		abajoi = new JPanel();
	

		this.setIconImage(s.label.imagenObjeto);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(940,480);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle(s.nombre);

	}



	public ImageIcon ResizeWindow(String ImagePath){
		ImageIcon MyImage = new ImageIcon(ImagePath);
		// medimos las dimensiones de la foto
		int w=MyImage.getIconWidth();
		int h=MyImage.getIconHeight();

		// si la foto es demasiado grande, la reducimos
		while(w>=2000 || h>920) {
			w=w/2;
			h=h/2;
		}

		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(w,h, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);


		// redimensionamos el frame
		label.setSize(w,h);
		arriba.setSize(w+300,h);
		abajo.setBounds(0,h,w, 120);
		arribad.setBounds(w,0,300,h);
		gafas.setLocation(w+50, 50);
		this.setSize(w+300,h+100);
		return image;
		
	}



	public static void main(String[] args) {
		JLabelGraficoAjustado label1 = new JLabelGraficoAjustado("gafas.png", 200,100);
		new VentanaGafa(new Gafas(label1,"1","Phoebe","negro","Ray-Ban",false,23,89.99,"Las gafas perfectas para la vida"));
	}

	
	
	// mover las gafaas
	
	public static void moverGafas(JLabelGraficoAjustado l, JPanel arriba) {
		
		
		

		Thread t = new Thread() {
//			public void run() {
//				
//				
//
//				do {
//					Point punto=MouseInfo.getPointerInfo().getLocation();
//					int x=punto.x;
//					int y=punto.y;
//					
//					System.out.println(raton);
//					
//					if(raton) {
//					l.setBounds(x,y,200,100);
//					}
//			
//			
			
			
			
			public void run() {
						
						int xa=0;
						int ya=0;
						int x=0;
						int y=0;
						
			

					do {
						Point punto2=MouseInfo.getPointerInfo().getLocation();
						int xb=punto2.x;
						int yb=punto2.y;
						
					//	System.out.println(xa+"  "+xb);
						

							
							x =l.getX()+(xb-xa);
							y =l.getY()+(yb-ya);
						
							if(raton && x<= (arriba.getWidth()-100) && y>=-50
									&& x>= -100 && y<= (arriba.getHeight())-50) {
							l.setLocation(x, y);
							}
						
					
						
						Point punto3=MouseInfo.getPointerInfo().getLocation();
						xa=punto3.x;
						ya=punto3.y;
						
							
						try {

							Thread.sleep(5);
						} catch (InterruptedException ex) {

						}

					} while (this.isAlive() );


				}



		};
		t.start();

	}



	
	

}

