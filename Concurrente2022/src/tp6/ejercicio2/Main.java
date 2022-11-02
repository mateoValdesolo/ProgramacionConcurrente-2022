package tp6.ejercicio2;

public class Main {

	public static void main(String[] args) {

		Sala sala = new Sala();

		Thread[] personas = new Thread[150];
		
		Thread medidor = new Thread(new MedidorTemperatura(sala));

		for (int i = 0; i < personas.length; i++) {
			personas[i] = new Thread(new Persona(sala), "Persona " + (i + 1));
		}
		
		medidor.start();

		for (int i = 0; i < personas.length; i++) {
			personas[i].start();
		}

	}

}
