package problemasClasicos.productorConsumidor;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore buffer = new Semaphore(4);
        Thread h2 = new Thread();
 
        Hilo hilo1 = new Hilo(buffer);
        Hilo2 hilo2[] = new Hilo2[6];

        for (int i = 0; i < hilo2.length; i++) {
            hilo2[i] = new Hilo2(buffer);
        }

        hilo1.start();

        for (int i = 0; i < hilo2.length; i++) {
            hilo2[i].start();
        }
    }

}

class Hilo extends Thread {

    private Semaphore sem;

    public Hilo(Semaphore sem) {
        this.sem = sem;
    }

    public void run() {
        try {
            System.out.println("Antes de hacer acquire");
            sem.acquire(10);
            System.out.println("Despues de hacer acquire");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Hilo2 extends Thread {

    private Semaphore sem;

    public Hilo2(Semaphore sem) {
        this.sem = sem;
    }

    public void run() {
        System.out.println("Antes de hacer release");
        sem.release(1);
        System.out.println("Despues de hacer release");

    }
}