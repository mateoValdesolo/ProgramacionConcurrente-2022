package problemasClasicos.productorConsumidor;

import java.util.concurrent.Semaphore;

public class Buffer {

    private Semaphore mutexProductor = new Semaphore(1);
    private Semaphore mutexConsumidor = new Semaphore(1);
    private Semaphore buffer;

    public Buffer(int cant) {
        this.buffer = new Semaphore(cant);
    }

    public void agregar(int cant) {
        try {
            mutexProductor.acquire();
            buffer.acquire(cant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutexProductor.release();
    }

    public void sacar(int cant) {
        try {
            mutexConsumidor.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer.release(cant);
        mutexConsumidor.release();
    }

}