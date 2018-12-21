import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.*;

public class Tablapedido extends JPanel
{
	public static JScrollPane scrollpane;
	public static  JTable table ;
	
	public Tablapedido()
    {
		int n = VentanaWeb.lista.size();
       
        String[] columnNames = {"",""};
        Object[][] data= new Object[n][2];
        
        for (int i = 0; i <n; i++) {
			
				Icon foto =VentanaWeb.resize(VentanaWeb.lista.get(i).label.nombreImagenObjeto,(int)VentanaWeb.redimx(200),(int)VentanaWeb.redimy(100));
				String precio =(""+VentanaWeb.lista.get(i).precio+"€");
				data[i][0]=foto;
				data[i][1]= precio;
		}
		
      

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	public boolean isCellEditable (int row,int column)
        	   {
        	       return false;
        	   }
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
        	  public Class getColumnClass(int column)
              {
                  return getValueAt(0, column).getClass();
              }
          };
        
        table = new JTable( model );
        table.setFont(new Font("Verdana", Font.ITALIC,32));
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0,0,0,80));
        table.addMouseListener(new MouseAdapter() {
        	
     
      	});
        
        
		table.setRowHeight((int)VentanaWeb.redimx(200));
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setGridColor(Color.black);
		
       scrollpane = new JScrollPane(table);
        this.add(scrollpane);
        
        scrollpane.setBackground(new Color(0,0,0,80));
        
    }
    
   

//  

}
