package tp5.ejercicio2.hashMap;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Comedor {

	private Semaphore semPrioridad; // Para el primero que entra, setea la prioridad de ingreso.
	private Semaphore mutex; // Para la exclusion mutua.
	private Semaphore semPlatos; // Simula la cantidad de platos.
	private int cantMaxima; // Cantidad maxima que pueden comer por turno.
	static private HashMap<String, Contador> map = new HashMap<String, Contador>();

	public Comedor(int cantMaxima, int cantPlatos) {
		this.cantMaxima = cantMaxima;
		semPrioridad = new Semaphore(1);
		mutex = new Semaphore(1);
		semPlatos = new Semaphore(cantPlatos);
		map.put("Gato", new Contador());
		map.put("Perro", new Contador());
	}

	public void entrar(String tipo) {
		try {
			mutex.acquire();
			map.get(tipo).incrementarCantEsperando();
			mutex.release();

			System.out.println(Thread.currentThread().getName() + " llega al comedor");

			map.get(tipo).tomarEntrar();

			mutex.acquire();
			map.get(tipo).decrementarCantEsperando();
			mutex.release();

			semPlatos.acquire();
			System.out.println(Thread.currentThread().getName() + " accede a un plato");

			mutex.acquire();
			map.get(tipo).incrementarCantComiendo();
			map.get(tipo).incrementarCantTotal();
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void irse(String tipo, String opuesto) {
		semPlatos.release();
		System.out.println(Thread.currentThread().getName() + " libera el plato");

		try {
			mutex.acquire();
			map.get(tipo).decrementarCantComiendo();

			if (map.get(tipo).getCantComiendo() == 0) {
				// Si no hay mas comiendo, soy el ultimo

				System.out.println(Thread.currentThread().getName() + " era el ultimo comiendo");

				if (map.get(tipo).getCantTotal() >= cantMaxima) {
					// Si llegue al maximo por turno

					if (map.get(opuesto).getCantEsperando() > 0) {
						// Si hay de los opuestos esperando por comer, los dejo pasar.

						System.out.println(Thread.currentThread().getName() + "  se llego al limite de " + tipo
								+ "s y hay " + opuesto + "s esperando");
						map.get(tipo).setCantComiendo(0);
						// Hay opuesto.
						map.get(opuesto).dejaEntrar(cantMaxima);

					} else {

						// No hay opuesto.
						if (map.get(tipo).getCantEsperando() > 0) {
							// Si hay de mi tipo esperando y llegue al limite, dejo entrar a 1.

							System.out.println(Thread.currentThread().getName() + "  se llego al limite de " + tipo
									+ "s NO HABIA " + (opuesto.toUpperCase()) + "S");
							// Pero si tipo.
							map.get(tipo).dejaEntrar(1);

						} else {
							// No hay de mi tipo esperando pero llegue al limite, entonces, reinicio.

							System.out.println(Thread.currentThread().getName() + "  se llego al limite de " + tipo
									+ "s NO HABIA " + (opuesto.toUpperCase()) + "S NI " + (tipo.toUpperCase()) + "S");
							// SETEAR EN 0
							// No hay niguno de los 2
							map.get(tipo).reiniciarEntrar();
							semPrioridad.release();
						}
					}

				} else {

					// Si no llegue al limite
					// Si no vienen mas tipo por el momento
					System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de " + tipo
							+ "s Y NO HABIA MAS " + (tipo.toUpperCase()) + "S");
					if (map.get(tipo).getCantEsperando() == 0) {
						// Si no llegue al maximo y soy el ultimo

						if (map.get(opuesto).getCantEsperando() > 0) {
							// Si hay del opuesto esperando y soy el ultimo, dejo entrar al opuesto.

							System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de " + tipo
									+ "s Y NO HABIA MAS " + (tipo.toUpperCase()) + "S PERO SI "
									+ (opuesto.toUpperCase()) + "S");
							map.get(tipo).reiniciarEntrar();
							map.get(opuesto).dejaEntrar(cantMaxima);
						} else {
							// Si soy el ultimo y no hay nadie esperando, reinicio.

							// Si no viene nadie
							System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de " + tipo
									+ "s Y NO HABIA MAS " + (tipo.toUpperCase()) + "S NI " + (opuesto.toUpperCase())
									+ "S");
							map.get(tipo).reiniciarEntrar();
							semPrioridad.release();
						}

					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();

		System.out.println(Thread.currentThread().getName() + " se va");

	}

	public void setearPrioridadAnimal(String tipo) {
		// El primero que entra setea la prioridad de ingreso.
		if (semPrioridad.tryAcquire()) {
			System.out.println(Thread.currentThread().getName() + " INICIAN LOS " + (tipo.toUpperCase()) + "S");
			map.get(tipo).dejaEntrar(cantMaxima);
		}
	}

}
