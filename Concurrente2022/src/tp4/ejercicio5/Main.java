package tp4.ejercicio5;

public class Main {
	public static void main(String[] args) {

		Taxi taxi = new Taxi();
		Taxista taxista = new Taxista(taxi);
		
		Thread clientes[] = new Thread[10];
		Thread hiloTaxista = new Thread(taxista);

		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Thread(new Cliente(taxi), "Cliente " + (i+1));
		}
		
		hiloTaxista.start();
		
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].start();
		}
	}
}
