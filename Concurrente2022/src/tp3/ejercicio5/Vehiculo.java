package tp3.ejercicio5;

/**
 *
 * @author Mateo Valdesolo
 */
public class Vehiculo {

	private String patente;
	private String modelo;
	private String marca;
	private int km;

	public Vehiculo(String patente, String modelo, String marca, int km) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.marca = marca;
		this.km = km;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
