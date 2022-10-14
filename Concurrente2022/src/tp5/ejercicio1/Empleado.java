package tp5.ejercicio1;

public class Empleado implements Runnable {

	private Comedor comedor;

	public Empleado(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		if (comedor.puedeSentarse()) {
			System.out.println(Thread.currentThread().getName() + " Se sento");

			switch (opcion()) {
			case 1:
				comedor.pedirBebida();
				System.out.println(Thread.currentThread().getName() + " Pidio Bebida");
				comedor.tomarBebida();
				System.out.println(Thread.currentThread().getName() + " Ya tomo la Bebida");
				break;
			case 2:

				comedor.pedirComida();
				System.out.println(Thread.currentThread().getName() + " Pidio comida");
				comedor.comerComida();
				System.out.println(Thread.currentThread().getName() + " Ya comio la Comida");
				break;
			case 3:
				comedor.pedirBebida();
				System.out.println(Thread.currentThread().getName() + " Pidio Bebida");
				comedor.tomarBebida();
				System.out.println(Thread.currentThread().getName() + " Ya tomo la Bebida");
				comedor.pedirComida();
				System.out.println(Thread.currentThread().getName() + " Pidio comida");
				comedor.comerComida();
				System.out.println(Thread.currentThread().getName() + " Ya comio la Comida");
				break;
			default:
				break;
			}

			comedor.levantarse();
			System.out.println(Thread.currentThread().getName() + " Se fue");
		} else {
			System.out.println(Thread.currentThread().getName() + " No pudo entrar a comer");
		}

	}

	private int opcion() {
		// 1 para solo bebida, 2 para comida, 3 para las 2.
		return (int) (Math.random() * (3)) + 1;
	}

}
