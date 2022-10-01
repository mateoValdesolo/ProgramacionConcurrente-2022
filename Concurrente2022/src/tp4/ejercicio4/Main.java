package tp4.ejercicio4;

public class Main {

	public static void main(String[] args) {
		CentroImpresion centro = new CentroImpresion(4, 4);

		Thread usuariosA[] = new Thread[10];
		Thread usuariosB[] = new Thread[10];
		Thread usuariosX[] = new Thread[10];

		for (int i = 0; i < usuariosA.length; i++) {
			usuariosA[i] = new Thread(new Usuario(centro, 'A'), "UsuarioA " + i);
		}

		for (int i = 0; i < usuariosB.length; i++) {
			usuariosB[i] = new Thread(new Usuario(centro, 'B'), "UsuarioB " + i);
		}

		for (int i = 0; i < usuariosX.length; i++) {
			usuariosX[i] = new Thread(new Usuario(centro, 'X'), "UsuarioX " + i);
		}

		for (int i = 0; i < usuariosA.length; i++) {
			usuariosA[i].start();
		}

		for (int i = 0; i < usuariosB.length; i++) {
			usuariosB[i].start();
		}

		for (int i = 0; i < usuariosX.length; i++) {
			usuariosX[i].start();
		}

	}

}