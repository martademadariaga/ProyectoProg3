import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JPanel
{
    public TableIcon(JPanel panel)
    {
        
    	GestionTienda.crearGafas("archivogafas.txt");
        String[] columnNames = {"", "",""};
        Object[][] data= new Object[10][3];
        int cont = 0;
        for (int i = 0; i <10; i++) {
			for (int j = 0; j < 3; j++) {
				// JLabel prueba = new JLabel(new ImageIcon("gafas.png"));
				Icon foto = new ImageIcon(GestionTienda.fotosgafas.get(cont));
				
				data[i][j]=foto;
				
				cont++;
			}
		}
      

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	public boolean isCellEditable (int row, int column)
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
        JTable table = new JTable( model );
        
        table.addMouseListener(new MouseAdapter() {
      	  public void mouseClicked(MouseEvent e) {
      	    if (e.getClickCount() == 2) {
      	      JTable target = (JTable)e.getSource();
      	      int row = target.getSelectedRow();
      	      int column = target.getSelectedColumn();
      	      Gafas gaf= GestionTienda.gafasDisp.get(row*3+column);
      	      new VentanaGafa(gaf);
      	    }
      	  }
      	});
        
        
		table.setRowHeight(200);
		panel.add(table);
        JScrollPane scrollPane = new JScrollPane( table );
        panel.add( scrollPane );
      
    }
    
   

//  

   
}
