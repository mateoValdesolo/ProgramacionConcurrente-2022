package tp4.ejercicio7;

public class Main {
    public static void main(String[] args) {
        int cantCoches = 50;

        GestorCruce gestor = new GestorCruce();
        ControlCruce contr = new ControlCruce(gestor);
        Thread hiloControl = new Thread(contr);
        Thread[] hiloCoches = new Thread[cantCoches];

        hiloControl.start();

        for (int i = 0; i < cantCoches; i++) {
            hiloCoches[i] = new Thread(new Coche(gestor), "Coche " + (i+1));
            hiloCoches[i].start();
        }
    }
}
