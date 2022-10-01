package tp4.ejercicio4;

import java.util.Random;

public class Usuario implements Runnable {

	private CentroImpresion centro;
	// Tipo A,B o X
	private char tipo;

	// Colores
	public static final String YELLOW = "\u001B[33m";
	public static final String GREEN = "\u001B[32m";
	public static final String RESET = "\u001B[0m";

	// Constructor
	public Usuario(CentroImpresion centro, char tipo) {
		this.centro = centro;
		this.tipo = tipo;
	}

	@Override
	public void run() {
		switch (tipo) {
		case 'A':
			int numImprA = impresoraRandom(this.tipo);
			imprimeA(numImprA);
			break;
		case 'B':
			int numImprB = impresoraRandom(this.tipo);
			imprimeB(numImprB);
			break;
		case 'X':
			char tipoRandom = tipoRandom();
			int numImpr = impresoraRandom(tipoRandom());
			if (tipoRandom == 'A') {
				imprimeA(numImpr);
			} else {
				imprimeB(numImpr);
			}
			break;
		default:
			break;
		}
	}

	public void imprimeA(int numImprA) {
		centro.imprimirA(numImprA);
		System.out.println(YELLOW + Thread.currentThread().getName() + " imprime en impresora A " + numImprA + RESET);
		espera();
		System.out.println(YELLOW + Thread.currentThread().getName() + " deja impresora A " + numImprA + RESET);
		centro.dejarA(numImprA);
	}

	public void imprimeB(int numImprB) {
		centro.imprimirB(numImprB);
		System.out.println(GREEN + Thread.currentThread().getName() + " imprime en impresora B " + numImprB + RESET);
		espera();
		System.out.println(GREEN + Thread.currentThread().getName() + " deja impresora B " + numImprB + RESET);
		centro.dejarB(numImprB);
	}

	private char tipoRandom() {
		Random r = new Random();
		return r.nextInt(2) + 1 == 1 ? 'A' : 'B';
	}

	private int impresoraRandom(char tipo) {
		Random r = new Random();
		return tipo == 'A' ? r.nextInt(centro.getCantA()) : r.nextInt(centro.getCantB());
	}

	private void espera() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}