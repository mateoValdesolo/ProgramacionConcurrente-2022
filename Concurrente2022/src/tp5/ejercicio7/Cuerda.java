package tp5.ejercicio7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuerda {

	private Semaphore semDerecha;
	private Semaphore semIzquierda;
	private Semaphore mutex;
	private int cantBabuinosEsperandoDer, cantBabuinosEsperandoIzq, cantBabuinosPasando, capacidadSoga;

	public Cuerda(int capacidadSoga) {
		semDerecha = new Semaphore(0);
		semIzquierda = new Semaphore(0);
		mutex = new Semaphore(1);
		cantBabuinosEsperandoDer = 0;
		cantBabuinosEsperandoIzq = 0;
		cantBabuinosPasando = 0;
		this.capacidadSoga = capacidadSoga;

	}

	public void pasar(char lado) {

		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (cantBabuinosPasando == 0) {

			if (lado == 'I') {
				System.out.println(Thread.currentThread().getName() + " ES EL PRIMER BABUINO Y VIENE DEL LADO IZQ");
				semIzquierda.release(capacidadSoga);
			} else {
				System.out.println(Thread.currentThread().getName() + " ES EL PRIMER BABUINO Y VIENE DEL LADO DER");
				semDerecha.release(capacidadSoga);
			}
		}
		mutex.release();

		if (lado == 'D') {

			if (!semDerecha.tryAcquire()) {
				System.out.println(Thread.currentThread().getName() + " no pudo pasar");
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cantBabuinosEsperandoDer++;
				System.out.println(Thread.currentThread().getName() + " debe esperar");
				mutex.release();
				try {
					semDerecha.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " termino de esperar puede pasar");
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cantBabuinosEsperandoDer--;
				mutex.release();

			} else {
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cantBabuinosPasando++;
				System.out.println(Thread.currentThread().getName() + " PUDO PASAR ");
				if (cantBabuinosPasando == capacidadSoga) {
					if (cantBabuinosEsperandoIzq > 0) {
						System.out.println(Thread.currentThread().getName()
								+ " ERA EL ULTIMO BABUINO DE LA DERECHA QUE PODIA PASAR Y LE DA EL PASO A LOS DE LA IZQ");
						semIzquierda.release(capacidadSoga);
					} else {
						if (cantBabuinosEsperandoDer > 0) {
							System.out.println(Thread.currentThread().getName()
									+ " ERA EL ULTIMO BABUINO DE LA DERECHA  PERO NO HABIA DE LA IZQ ");
							semDerecha.release();
						}
					}

				} else {
					if (cantBabuinosEsperandoDer == 0) {
						if (cantBabuinosEsperandoIzq > 0) {
							semIzquierda.release(capacidadSoga);
							semDerecha = new Semaphore(0);
						}
					}

				}
				mutex.release();

			}
		} else {
			if (!semIzquierda.tryAcquire()) {
				System.out.println(Thread.currentThread().getName() + " no pudo pasar");
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cantBabuinosEsperandoIzq++;
				System.out.println(Thread.currentThread().getName() + " debe esperar");
				mutex.release();

				try {
					semIzquierda.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " termino de esperar puede pasar");
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cantBabuinosEsperandoIzq--;
				mutex.release();
			} else {
				try {
					mutex.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cantBabuinosPasando++;
				System.out.println(Thread.currentThread().getName() + " PUDO PASAR ");
				if (cantBabuinosPasando == capacidadSoga) {
					if (cantBabuinosEsperandoDer > 0) {
						System.out.println(Thread.currentThread().getName()
								+ " ERA EL ULTIMO BABUINO DE LA DERECHA QUE PODIA PASAR Y LE DA EL PASO A LOS DE LA IZQ");
						semDerecha.release(capacidadSoga);
					} else {
						if (cantBabuinosEsperandoIzq > 0) {
							System.out.println(Thread.currentThread().getName()
									+ " ERA EL ULTIMO BABUINO DE LA DERECHA  PERO NO HABIA DE LA IZQ ");
							semIzquierda.release();
						}
					}

				} else {
					if (cantBabuinosEsperandoIzq == 0) {
						if (cantBabuinosEsperandoDer > 0) {
							semDerecha.release(capacidadSoga);
							semIzquierda = new Semaphore(0);
						}
					}
				}
				mutex.release();

			}

		}
	}

	public void irse() {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cantBabuinosPasando--;
		mutex.release();
	}

}