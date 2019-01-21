import java.awt.Component;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenderJCombobox extends JLabel implements ListCellRenderer {
	    /** Para guardar los iconos por cada item. El item es la clave y el valor
	     * es el icono.
	     */
	    Hashtable<Object, ImageIcon> icono = null;

	    /**
	     * Construye el Hashtable con los iconos seleccionados, asociándolos a los
	     * items que tendrá el JComboBox "uno", "dos", "tres" y "cuatro"
	     */
	    public RenderJCombobox() {
	        icono = new Hashtable<Object, ImageIcon>();
	        icono.put("cero", new ImageIcon("multi.jpg"));
	        icono.put("uno", new ImageIcon("amarillo.jpg"));
	        icono.put("dos", new ImageIcon("verde.jpg"));
	        icono.put("tres", new ImageIcon("rosa.jpg"));
	        icono.put("cuatro", new ImageIcon("rojo.jpg"));
	        icono.put("cinco", new ImageIcon("azul.jpg"));
	        icono.put("seis", new ImageIcon("negro.jpg"));
	      
	    }

	    /**
	     * En función del value que se pasa (el item del JComboBox), se pone el icono
	     * y se devuelve el JLabel.
	     */
	    @Override
	    public Component getListCellRendererComponent(JList list, Object value,
	            int index, boolean isSelected, boolean cellHasFocus) {
	        if (icono.get(value) != null)
	            setIcon(icono.get(value));
	        else
	            setIcon(null);
	        return this;
	    }

	}
