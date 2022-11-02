package tp5.ejercicio7.hashMap;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Cuerda {

	private Semaphore mutex, semPrioridad, semCuerda;
	private int cantMaxima;
	static private HashMap<String, Contador> map = new HashMap<String, Contador>();

	public Cuerda() {
		this.cantMaxima = 5;
		mutex = new Semaphore(1);
		semPrioridad = new Semaphore(1);
		semCuerda = new Semaphore(cantMaxima);
		map.put("Izquierda", new Contador());
		map.put("Derecha", new Contador());
	}

	public void entrar(String tipo) {
		try {
			mutex.acquire();
			map.get(tipo).incrementarCantEsperando();
			mutex.release();

			System.out.println(Thread.currentThread().getName() + " llega a la cuerda desde la " + tipo);

			map.get(tipo).tomarEntrar();

			mutex.acquire();
			map.get(tipo).decrementarCantEsperando();
			mutex.release();

			semCuerda.acquire();
			System.out.println(Thread.currentThread().getName() + " se sube a la cuerda desde la " + tipo);

			mutex.acquire();
			map.get(tipo).incrementarCantPasando();
			map.get(tipo).incrementarCantTotal();
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void irse(String tipo, String opuesto) {
		semCuerda.release();
		System.out.println(Thread.currentThread().getName() + " libera la cuerda");

		try {
			mutex.acquire();
			map.get(tipo).decrementarCantPasando();

			if (map.get(tipo).getCantPasando() == 0) {
				// Si no hay mas en la cuerda, soy el ultimo

				System.out.println(Thread.currentThread().getName() + " era el ultimo pasando de la " + tipo);

				if (map.get(tipo).getCantTotal() >= cantMaxima) {
					// Si llegue al maximo por turno

					if (map.get(opuesto).getCantEsperando() > 0) {
						// Si hay de los opuestos esperando para pasar, los dejo pasar.

						System.out.println(Thread.currentThread().getName() + "  se llego al limite de la " + tipo
								+ " y hay de la " + opuesto + " esperando");
						map.get(tipo).setCantPasando(0);
						// Hay opuesto.
						map.get(opuesto).dejaEntrar(cantMaxima);

					} else {

						// No hay opuesto.
						if (map.get(tipo).getCantEsperando() > 0) {
							// Si hay de mi tipo esperando y llegue al limite, dejo entrar a 1.

							System.out.println(Thread.currentThread().getName() + "  se llego al limite de la " + tipo
									+ " NO HABIA DE LA " + (opuesto.toUpperCase()));
							// Pero si tipo.
							map.get(tipo).dejaEntrar(1);

						} else {
							// No hay de mi tipo esperando pero llegue al limite, entonces, reinicio.

							System.out.println(Thread.currentThread().getName() + "  se llego al limite de la " + tipo
									+ " NO HABIA DE LA " + (opuesto.toUpperCase()) + " NI " + (tipo.toUpperCase()));
							// SETEAR EN 0
							// No hay niguno de los 2
							map.get(tipo).reiniciarEntrar();
							semPrioridad.release();
						}
					}

				} else {

					// Si no llegue al limite
					// Si no vienen mas tipo por el momento
					System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de la " + tipo
							+ " Y NO HABIA MAS DE LA " + (tipo.toUpperCase()));
					if (map.get(tipo).getCantEsperando() == 0) {
						// Si no llegue al maximo y soy el ultimo

						if (map.get(opuesto).getCantEsperando() > 0) {
							// Si hay del opuesto esperando y soy el ultimo, dejo entrar al opuesto.

							System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de la "
									+ tipo + " Y NO HABIA MAS DE LA " + (tipo.toUpperCase()) + " PERO SI DE LA "
									+ (opuesto.toUpperCase()));
							map.get(tipo).reiniciarEntrar();
							map.get(opuesto).dejaEntrar(cantMaxima);
						} else {
							// Si soy el ultimo y no hay nadie esperando, reinicio.

							// Si no viene nadie
							System.out.println(Thread.currentThread().getName() + "  NO se llego al limite de la "
									+ tipo + " Y NO HABIA MAS DE LA " + (tipo.toUpperCase()) + " NI DE LA "
									+ (opuesto.toUpperCase()));
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

	public void setearPrioridadBabuino(String tipo) {
		// El primero que entra setea la prioridad de ingreso.
		if (semPrioridad.tryAcquire()) {
			System.out.println(Thread.currentThread().getName() + " INICIAN LOS DE LA " + (tipo.toUpperCase()));
			map.get(tipo).dejaEntrar(cantMaxima);
		}
	}

}
