import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


public class GestionTienda {
	public static ArrayList<Gafas> gafasDisp = new ArrayList<Gafas>();
	public static ArrayList<Gafas> gafasTienda = new ArrayList<Gafas>();
	public static ArrayList<String> fotosgafas = new ArrayList<String>();

	
	public static void crearGafas(String s) {
		int contador = 0;
		String linea;
		FileReader fr= null;
		BufferedReader br= null;
		try {
			fr = new FileReader(s);
			br= new BufferedReader(fr);
			linea = br.readLine();

			while(linea!= null) {
				String[] partes= new String[100];
				partes =linea.split(",");

				gafasTienda.add( new Gafas(new JLabelGraficoAjustado(partes[0], 200,100),
						partes[1],partes[2],partes[3],partes[4],Boolean.parseBoolean(partes[5]),
						Integer.parseInt(partes[6]),Double.parseDouble(partes[7]),partes[8]));

				fotosgafas.add(partes[0]);
				linea = br.readLine();


			}
		gafasDisp=gafasTienda;
		
	  


		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	public static void main(String[] args) {
		crearGafas("archivogafas.txt");
		System.out.println(gafasTienda.size());
		
		
	}
}
