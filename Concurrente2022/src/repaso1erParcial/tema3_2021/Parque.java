package repaso1erParcial.tema3_2021;

public class Parque {

	private int cantSnorkel;
	private int cantAntiparras;
	private Objeto antiparras[];
	private Objeto snorkels[];

	public Parque(int cantSnorkel, int cantAntiparras) {
		this.cantSnorkel = cantSnorkel;
		this.cantAntiparras = cantAntiparras;

		antiparras = new Objeto[cantAntiparras];
		snorkels = new Objeto[cantSnorkel];

		for (int i = 0; i < antiparras.length; i++) {
			antiparras[i] = new Objeto();
		}

		for (int i = 0; i < snorkels.length; i++) {
			snorkels[i] = new Objeto();
		}
	}

	public int pedirAntiparra() {
		int pos = 0;
		boolean exito = false;
		while (pos < cantAntiparras && antiparras[pos].getEstado() && !exito) {
			if (antiparras[pos].usar()) {
				exito = true;
			} else {
				pos++;
			}
		}
		if (!exito) {
			pos = -1;
		}
		return pos;
	}

	public int pedirSnorkel() {
		int pos = 0;
		boolean exito = false;
		while (pos < cantSnorkel && snorkels[pos].getEstado() && !exito) {
			if (snorkels[pos].usar()) {
				exito = true;
			} else {
				pos++;
			}
		}
		if (!exito) {
			pos = -1;
		}
		return pos;
	}

	public void devolver(int numAntiparra, int numSnorkel) {

		boolean snorkelRoto = seRompio();
		boolean antiparrasRoto = seRompio();
		if (!snorkelRoto) {
			System.out.println("El snorkel nro." + numSnorkel + " se rompio");
		}
		if (!antiparrasRoto) {
			System.out.println("El antiparras nro." + numAntiparra + " se rompio");
		}
		antiparras[numAntiparra].marcarRoto();
		snorkels[numSnorkel].marcarRoto();

		antiparras[numAntiparra].dejarDeUsar();
		snorkels[numSnorkel].dejarDeUsar();
	}

	private boolean seRompio() {
		int roto = ((int) (Math.random() * 4 + 1));
		return roto == 2;
	}

}
