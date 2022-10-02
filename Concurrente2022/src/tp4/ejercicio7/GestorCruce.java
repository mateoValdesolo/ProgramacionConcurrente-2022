package tp4.ejercicio7;

import java.util.concurrent.Semaphore;

public class GestorCruce {

    private Semaphore oesteEste;
    private Semaphore norteSur;
    private Semaphore sensorOeste;
    private Semaphore sensorNorte;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public GestorCruce() {
        /*
         * 1 se puede usar, 0 no. Release lo deja para usarse, Acquire para que no.
         */
        this.norteSur = new Semaphore(1, true);
        this.sensorNorte = new Semaphore(1,true);

        this.oesteEste = new Semaphore(0, true);
        this.sensorOeste = new Semaphore(0,true);
    }

    public void llegaNorte() {
        try {
            System.out.println(Thread.currentThread().getName() + ANSI_CYAN + " Llego Norte" + ANSI_RESET);
            sensorNorte.acquire();
        } catch (Exception e) {

        }
    }

    public void llegaOeste() {
        try {
            System.out.println(Thread.currentThread().getName() + ANSI_PURPLE + " Llego Oeste" + ANSI_RESET);
            sensorOeste.acquire();
        } catch (Exception e) {

        }
    }

    public void sale(int direccion) {
        if(direccion == 2){
            this.sensorOeste.release();
        } else {
            this.sensorNorte.release();
        }
        System.out.println(Thread.currentThread().getName() +" Cruzo");
    }

    public void cambiarSemaforos() {
        if (norteSur.tryAcquire()) {
            try {
                sensorNorte.acquire();
            } catch (Exception e) {
                
            }
            oesteEste.release();
            sensorOeste.release();
            System.out.println(ANSI_GREEN + "Semaforo Oeste en Verde" + ANSI_RED + " Norte en Rojo" + ANSI_RESET);
        } else {
            try {
                sensorOeste.acquire();
            } catch (Exception e) {
                
            }
            norteSur.release();
            sensorNorte.release();
            System.out.println(ANSI_RED + "Semaforo Oeste en Rojo" + ANSI_GREEN + " Norte en Verde" + ANSI_RESET);
        }
    }

}