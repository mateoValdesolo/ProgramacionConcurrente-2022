package tp5.ejercicio7;

import java.util.concurrent.Semaphore;

public class Cuerda {
	private int cantBabuinosLadoIzqEsperando, cantBabuinosLadoDerEsperando, cantTotalBabuinosLadoIzq,
			cantTotalBabuinosLadoDer, limite, cantBabuinosLadoIzqPasando, cantBabuinosLadoDerPasando;
	private Semaphore mutex, entrarPrimerBabuino;
	private Semaphore entrarBabuinosLadoIzq;
	private Semaphore entrarBabuinosLadoDer;
	private Semaphore espacioCuerda;

	public Cuerda() {
		cantBabuinosLadoIzqEsperando = 0;
		cantBabuinosLadoDerEsperando = 0;
		cantBabuinosLadoDerPasando = 0;
		cantBabuinosLadoIzqPasando = 0;
		cantTotalBabuinosLadoDer = 0;
		cantTotalBabuinosLadoIzq = 0;
		this.limite = 5;
		mutex = new Semaphore(1);
		entrarPrimerBabuino = new Semaphore(1);
		entrarBabuinosLadoIzq = new Semaphore(0);
		entrarBabuinosLadoDer = new Semaphore(0);
		espacioCuerda = new Semaphore(limite);
	}

	public void entrar(char lado) {
		if (lado == 'I') {
			try {
				mutex.acquire();
				cantBabuinosLadoIzqEsperando++;
				mutex.release();

				System.out.println(Thread.currentThread().getName() + ": Llego del lado Izquierdo");

				entrarBabuinosLadoIzq.acquire();

				mutex.acquire();
				cantBabuinosLadoIzqEsperando--;
				mutex.release();

				espacioCuerda.acquire();
				System.out.println(Thread.currentThread().getName() + ": Pasando la cuerda desde la izquierda");

				mutex.acquire();
				cantBabuinosLadoIzqPasando++;
				cantTotalBabuinosLadoIzq++;
				mutex.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			try {
				mutex.acquire();
				cantBabuinosLadoDerEsperando++;
				mutex.release();
				System.out.println(Thread.currentThread().getName() + ": LLegúe del lado der");

				entrarBabuinosLadoDer.acquire();

				mutex.acquire();
				cantBabuinosLadoDerEsperando--;
				mutex.release();

				espacioCuerda.acquire();
				System.out.println(Thread.currentThread().getName() + ": Pasando la cuerda desde la derecha");

				mutex.acquire();
				cantBabuinosLadoDerPasando++;
				cantTotalBabuinosLadoDer++;
				mutex.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void irse(char lado) {
		espacioCuerda.release();
		System.out.println(Thread.currentThread().getName() + ": Pasé la cuerda");

		if (lado == 'I') {
			this.irseLadoIzq();
		} else {
			this.irseLadoDer();

		}
		System.out.println(Thread.currentThread().getName() + " se fué");

	}

	private void irseLadoIzq() {
		try {
			mutex.acquire();
			cantBabuinosLadoIzqPasando--;

			if (cantBabuinosLadoIzqPasando == 0) {
				System.out.println(
						Thread.currentThread().getName() + " era el ultimo babuino del lado izq pasando la cuerda");
				if (cantTotalBabuinosLadoIzq >= limite) {
					if (cantBabuinosLadoDerEsperando > 0) {
						System.out.println(Thread.currentThread().getName()
								+ "  se llego al limite de babuinos del lado IZQ y hay babuinos del otro lado esperando. Dejo que pasen ellos");
						cantBabuinosLadoIzqPasando = 0;
						// hay babuinos del otro lado
						entrarBabuinosLadoDer.release(limite);

					} else {
						// no hay babuinos del otro lado
						if (cantBabuinosLadoIzqEsperando > 0) {
							System.out.println(Thread.currentThread().getName()
									+ "  se llego al limite de babuinos del lado IZQ pero NO HAY NADIE DEL OTRO LADO y si de mi lado");
							// pero si gatos
							entrarBabuinosLadoIzq.release();
						} else {
							System.out.println(Thread.currentThread().getName()
									+ "  se llego al limite Y NO HAY BABUINOS DE NINGUN LADO ESPERANDO");
							// SETEAR EN 0
							// no hay niguno de los 2
							entrarBabuinosLadoIzq = new Semaphore(0);
							entrarPrimerBabuino.release();

						}
					}
				} else {
					// si no llegue al limite
					// si no vienen mas gatos por el momento
					System.out.println(Thread.currentThread().getName()
							+ "  NO se llego al limite de la cuerda Y NO HAY MAS BABUINOS DEL LADO IZQ");
					if (cantBabuinosLadoIzqPasando == 0) {
						if (cantBabuinosLadoDerEsperando > 0) {
							System.out.println(Thread.currentThread().getName()
									+ "  NO se llego al limite de la cuerda  Y HAY BABUINOS DEL LADO DER ESPERANDO");
							entrarBabuinosLadoIzq = new Semaphore(0);
							entrarBabuinosLadoDer.release(limite);
						} else {
							// si no viene nadie
							System.out.println(Thread.currentThread().getName()
									+ "  NO se llego al limite de la cuerda Y NO HAY NINGUN BABUINO DE NINGUN LADO");
							entrarBabuinosLadoIzq = new Semaphore(0);
							entrarPrimerBabuino.release();
						}

					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();

	}

	private void irseLadoDer() {
		try {
			mutex.acquire();
			cantBabuinosLadoDerPasando--;
			if (cantBabuinosLadoDerPasando == 0) {
				System.out
						.println(Thread.currentThread().getName() + " era el ultimo babuino del lado derecho pasando");
				if (cantTotalBabuinosLadoDer >= limite) {
					if (cantBabuinosLadoIzqEsperando > 0) {
						System.out.println(Thread.currentThread().getName()
								+ "  se llego al limite de la cuerda y hay babuinos del lado IZQ esperando");
						cantBabuinosLadoDerPasando = 0;
						// hay gatos
						entrarBabuinosLadoIzq.release(limite);

					} else {
						// no hay gatos
						if (cantBabuinosLadoDerEsperando > 0) {
							System.out.println(Thread.currentThread().getName()
									+ "  se llego al limite de la cuerda pero NO HAY BABUINOS DEL LADO IZQ ESPERANDO");
							// pero si perros
							entrarBabuinosLadoDer.release();
						} else {
							System.out.println(Thread.currentThread().getName()
									+ "  se llego al limite de la cuerda pero NO HAY BABUINOS DE NINGUN LADO");
							entrarBabuinosLadoDer = new Semaphore(0);
							entrarPrimerBabuino.release();

						}
					}
				} else {
					// si no llegue al limite y no vienen mas perros por el momento
					if (cantBabuinosLadoDerEsperando == 0) {
						if (cantBabuinosLadoIzqEsperando > 0) {
							System.out.println(Thread.currentThread().getName()
									+ "  NO se llego al limite de la cuerda pero HAY BABUINOS DEL LADO IZQ ESPERANDO ");
							entrarBabuinosLadoDer = new Semaphore(0);
							entrarBabuinosLadoIzq.release(limite);
						} else {
							// si no viene nadie
							System.out.println(Thread.currentThread().getName()
									+ "  NO se llego al limite de la cuerda pero NO HAY BABUINOS DE NINGUN LADO ");
							entrarBabuinosLadoDer = new Semaphore(0);
							entrarPrimerBabuino.release();
						}

					}

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();

	}

	public void setearPrioridadBabuino(char lado) {
		if (entrarPrimerBabuino.tryAcquire()) {
			if (lado == 'I') {
				System.out.println(Thread.currentThread().getName() + " PASAN PRIMERO LOS DEL LADO IZQ ");
				entrarBabuinosLadoIzq.release(limite);
			} else {
				System.out.println(Thread.currentThread().getName() + " PASAN PRIMERO LOS DEL LADO DER");
				entrarBabuinosLadoDer.release(limite);
			}

		}
	}

}