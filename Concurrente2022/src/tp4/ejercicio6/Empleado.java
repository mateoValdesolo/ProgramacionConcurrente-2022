package tp4.ejercicio6;

public class Empleado implements Runnable {

	private Comedor comedor;

	public Empleado(Comedor comedor) {
		this.comedor = comedor;
	}

	@Override
	public void run() {
		comedor.sentarse();
		System.out.println(Thread.currentThread().getName() + " se sento");
		comedor.elegirComida();
		comedor.empezarComer();
		System.out.println(Thread.currentThread().getName() + " esta comiendo");
		comedor.volverATrabajar();
	}
}
