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
	public JButton browse, agregar;
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
		arriba.setBounds(0, 0,(int)VentanaWeb.redimx(940),(int)VentanaWeb.redimy(380));
		cp.add(arriba);

		
		
		// panel browse
		abajo = new JPanel();
		abajo.setLayout(new GridLayout(1,1));
		cp.add(abajo);
		browse = new JButton(VentanaWeb.resize("browse.jpeg",(int)VentanaWeb.redimx(1500),(int)VentanaWeb.redimy(60)));
		abajo.add(browse);
		abajo.setBounds(0, (int)VentanaWeb.redimy(380), (int)VentanaWeb.redimx(640),(int)VentanaWeb.redimy(60));
		agregar = new JButton(VentanaWeb.resize("agregar.jpeg", (int)VentanaWeb.redimx(300), (int)VentanaWeb.redimy(60)));
		cp.add(agregar);
		agregar.setBounds((int)VentanaWeb.redimx(640), (int)VentanaWeb.redimy(380), (int)VentanaWeb.redimx(300), (int)VentanaWeb.redimy(60));
		
	
		
		// gafas
		
		gafas = s.label;
		arriba.add(s.label);
		gafas.setLocation((int)VentanaWeb.redimx(590), (int)VentanaWeb.redimy(50));
		gafas.setSize((int)VentanaWeb.redimy(400),(int)VentanaWeb.redimy(200));
		gafas.zoom=0.5;
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
				arribad.setBounds((int)VentanaWeb.redimx(640),0,(int)VentanaWeb.redimx(300),(int)VentanaWeb.redimy(480));
				arribad.setBackground(Color.white);
				arriba.add(arribad);
				

				zoom = new JSlider();
				zoom.setMaximum(300);
				zoom.setMinimum(25);
				zoom.setValue(100);
				arribad.add(zoom);
				zoom.setLocation((int)VentanaWeb.redimx(690), (int)VentanaWeb.redimy(50));
				zoom.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
					
					
					gafas.setSize((int)VentanaWeb.redimx(200*zoom.getValue()/50),(int)VentanaWeb.redimy( 100*zoom.getValue()/50));
					}
					
				});
				
				rotar = new JSlider();
				rotar.setMaximum(180);
				rotar.setMinimum(-180);
				rotar.setValue(0);
				arribad.add(rotar);
				rotar.setLocation((int)VentanaWeb.redimx(690), (int)VentanaWeb.redimy(150));
				rotar.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
					
					
					gafas.setRotacion(Math.toRadians(rotar.getValue()));
					
					}
					
				});
				
				

		
		
		
		// pane de la foto
		
		label = new JLabel(VentanaWeb.resize("predet.png",(int)VentanaWeb.redimx(640),(int)VentanaWeb.redimy(380)));
		arriba.add(label);
		
		label.setSize((int)VentanaWeb.redimx(640),(int)VentanaWeb.redimy(380));
	
		

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

		agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			VentanaWeb.lista.add(s);
			VentanaWeb.actualizarlista();
			}
			
		});
	
		
		//abajo
		

		this.setIconImage(s.label.imagenObjeto);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize((int)VentanaWeb.redimx(940),(int)VentanaWeb.redimy(480));
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
		while(w>=VentanaWeb.redimx(2000) || h>VentanaWeb.redimy(920)) {
			w=w/2;
			h=h/2;
		}

		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(w,h, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);


		// redimensionamos el frame
		label.setSize(w,h);
		arriba.setSize(w+(int)VentanaWeb.redimx(300),h);
		abajo.setBounds(0,h,w, (int)VentanaWeb.redimy(60));
		agregar.setBounds(w, h, (int)VentanaWeb.redimx(300), (int)VentanaWeb.redimy(60));
		arribad.setBounds(w,0,(int)VentanaWeb.redimx(300),h);
		gafas.setLocation(w-(int)VentanaWeb.redimx(50), (int)VentanaWeb.redimy(50));
		this.setSize(w+(int)VentanaWeb.redimx(300),h+(int)VentanaWeb.redimy(100));
		return image;
		
	}



//	public static void main(String[] args) {
//		JLabelGraficoAjustado label1 = new JLabelGraficoAjustado("gafas.png", 200,100);
//		new VentanaGafa(new Gafas(label1,"1","Phoebe","negro","Ray-Ban",false,23,89.99,"Las gafas perfectas para la vida"));
//	}

	
	
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
						
							if(raton && x<= (arriba.getWidth()-(int)VentanaWeb.redimx(100)) && y>=-(int)VentanaWeb.redimy(50)
									&& x>= -(int)VentanaWeb.redimx(100) && y<= (arriba.getHeight())-(int)VentanaWeb.redimy(50)) {
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

