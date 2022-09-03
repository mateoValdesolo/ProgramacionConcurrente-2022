package tp3.ejercicio6;

/**
 *
 * @author Mateo Valdesolo
 */
public class Sumadores implements Runnable {

	private int[] arr;
	private int inicioSuma, finSuma;
	private Suma sumaCompartida;

	public void run() {
		int sumaParcial = 0;
		
		for (int i = inicioSuma; i < finSuma; i++) {
			sumaParcial += arr[i];
		}

		sumaCompartida.sumar(sumaParcial);
	}

	public Sumadores(int[] arr, int inicioSuma, int finSuma, Suma sumaCompartida) {
		this.arr = arr;
		this.inicioSuma = inicioSuma;
		this.finSuma = finSuma;
		this.sumaCompartida = sumaCompartida;
	}

}
