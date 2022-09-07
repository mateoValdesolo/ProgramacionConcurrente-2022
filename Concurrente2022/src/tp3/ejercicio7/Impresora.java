package tp3.ejercicio7;

import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Impresora implements Runnable {

	private char letraImprimir;
	private Letra letra;

	public Impresora(char letraImprimir, Letra letra) {
		super();
		this.letraImprimir = letraImprimir;
		this.letra = letra;
	}

	@Override
	public void run() {
		while (true) {

			if (letra.getTurno() == letraImprimir) {
				int cant = cantRandom();
				for (int i = 0; i < cant; i++) {
					letra.imprimir(letraImprimir);
				}

				letra.setTurno(siguienteLetra());

			} else {
				espera();
			}
		}
	}

	private int cantRandom() {
		Random r = new Random();
		return r.nextInt(10) + 1;
	}

	private void espera() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private char siguienteLetra() {
		char letra = ' ';
		switch (letraImprimir) {
		case 'A':
			letra = 'B';
			break;
		case 'B':
			letra = 'C';
			break;
		case 'C':
			letra = 'A';
			break;
		default:
			break;
		}
		return letra;
	}

}
