package tp3.ejercicio3;

/**
 *
 * @author Mateo Valdesolo
 */
public class Main {

	public static void main(String[] args) {
		Sala sala = new Sala(5);
		Encargado encargado = new Encargado(sala);
		Thread[] clientes = new Thread[30];

		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Thread(new Cliente(encargado), "#" + i);
		}
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].start();
		}

	}
}
