package problemasClasicos.productorConsumidor;

public class Productor implements Runnable {

    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        
    }

}