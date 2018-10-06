
public class Gafas {
	public JLabelGraficoAjustado label;
	public String ident;
	public String nombre;
	public String Colores;
	public String Marca;
	public boolean sol;
	public int stock;
	public double precio;
	public String descripción;
	
	

	

	public Gafas(JLabelGraficoAjustado label, String ident, String nombre, String colores, String marca, boolean sol,
			int stock, double precio, String descripción) {
		super();
		this.label = label;
		this.ident = ident;
		this.nombre = nombre;
		Colores = colores;
		Marca = marca;
		this.sol = sol;
		this.stock = stock;
		this.precio = precio;
		this.descripción = descripción;
	}

	
	
	public String getColores() {
		return Colores;
	}



	public void setColores(String colores) {
		Colores = colores;
	}



	public String getMarca() {
		return Marca;
	}



	public void setMarca(String marca) {
		Marca = marca;
	}



	public int getStock() {
		return stock;
	}



	public JLabelGraficoAjustado getLabel() {
		return label;
	}

	public void setLabel(JLabelGraficoAjustado label) {
		this.label = label;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isSol() {
		return sol;
	}

	public void setSol(boolean sol) {
		this.sol = sol;
	}

	public int isStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}



	@Override
	public String toString() {
		return "Gafas [label=" + label + ", ident=" + ident + ", nombre=" + nombre + ", Colores=" + Colores + ", Marca="
				+ Marca + ", sol=" + sol + ", stock=" + stock + ", precio=" + precio + ", descripción=" + descripción
				+ "]";
	}
	
	
	
	
	
	
}
