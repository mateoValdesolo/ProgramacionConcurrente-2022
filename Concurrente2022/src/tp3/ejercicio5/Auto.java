package tp3.ejercicio5;

import java.util.Random;

/**
 *
 * @author Mateo Valdesolo
 */
public class Auto extends Vehiculo implements Runnable {

    private final int ltsCombustible;
    private int ltsCombustibleActual;
    private final int ltsReserva;
    private Surtidor surtidor;

    public Auto(String patente, String modelo, String marca, int km, Surtidor surtidor, int ltsCombustible, int ltsReserva) {
        super(patente, modelo, marca, km);
        this.ltsCombustible = ltsCombustible;
        this.ltsCombustibleActual = ltsCombustible;
        this.ltsReserva = ltsReserva;
        this.surtidor = surtidor;
    }

    @Override
    public void run() {
        while (ltsCombustibleActual > 0) {
            if (ltsCombustibleActual <= ltsReserva) {
                surtidor.cargarCombustible(60 - ltsCombustibleActual);
                this.ltsCombustibleActual = ltsCombustible;
            } else {
                andarKm(ltsCombustibleActual - ltsReserva);
                System.out.println(
                        Thread.currentThread().getName() + " le faltan " + (ltsCombustibleActual - ltsReserva) + " para la reserva");
            }
        }
    }

    private void espera() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void andarKm(int i) {
        Random r = new Random();
        this.ltsCombustibleActual -= (r.nextInt(i) + 1);
        espera();
    }

}
