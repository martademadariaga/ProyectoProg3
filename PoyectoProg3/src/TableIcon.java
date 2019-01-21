import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JPanel
{
	public TableIcon()
    {
        
        String[] columnNames = {"", "",""};
        int n;
        if(GestionTienda.gafasDisp.size()%3==0) {
        	n=GestionTienda.gafasDisp.size()/3;
        }else {
        	n=GestionTienda.gafasDisp.size()/3+1;
        }
        Object[][] data= new Object[n][3];
        int cont = 0;
        for (int i = 0; i <n; i++) {
			for (int j = 0; j < 3; j++) {
				// JLabel prueba = new JLabel(new ImageIcon("gafas.png"));
				//Icon foto = VentanaWeb.resize(GestionTienda.fotosgafas.get(cont),(int)VentanaWeb.redimx(200),(int)VentanaWeb.redimy(100));
				if(cont<GestionTienda.gafasDisp.size()) {
				Icon foto = VentanaWeb.resize(GestionTienda.gafasDisp.get(cont).label.nombreImagenObjeto,(int)VentanaWeb.redimx(200),(int)VentanaWeb.redimy(100));
				data[i][j]=foto;
				}
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
        
        
		table.setRowHeight((int)VentanaWeb.redimy(200));
		
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		//table.setCellSelectionEnabled(true);
		table.setGridColor(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
      
    }
    
   

//  

   
}
