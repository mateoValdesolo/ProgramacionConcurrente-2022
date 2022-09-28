package tp3.ejercicio7;

import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Impresora implements Runnable {

    private static int cantRonda;
    private char letraImprimir;
    private Letra letra;
    private int cantImprimir;

    public Impresora(char letraImprimir, Letra letra, int cantImprimir) {
        this.letraImprimir = letraImprimir;
        this.letra = letra;
        this.cantImprimir = cantImprimir;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < cantRonda) {

            if (letra.getTurno() == letraImprimir) {

                for (int j = 0; j < cantImprimir; j++) {
                    letra.imprimir(letraImprimir);
                }
                i++;
                letra.setTurno(siguienteLetra());
                
            } else {
                espera();
            }
        }
    }

    private void espera() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char siguienteLetra() {
        char letra = ' ';
        switch (letraImprimir) {
            case 'A':
                letra = 'B';
                break;
            case 'B':
                letra = 'C';
                break;
            case 'C':
                letra = 'A';
                break;
            default:
                break;
        }
        return letra;
    }

    public static void setRonda(int cantRonda) {
        Impresora.cantRonda = cantRonda;
    }

}

