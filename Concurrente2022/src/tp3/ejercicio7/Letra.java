package tp3.ejercicio7;

/**
 *
 * @author Mateo Valdesolo
 */
public class Letra {

	private char turno;

	public Letra() {
		this.turno = 'A';
	}

	public synchronized void imprimir(char letra) {
		System.out.print(letra);
	}

	public synchronized char getTurno() {
		return turno;
	}
	
	public synchronized void setTurno(char turno) {
		 this.turno = turno;
	}

}
