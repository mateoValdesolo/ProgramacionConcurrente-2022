package problemasClasicos.productorConsumidor;

public class Consumidor implements Runnable{

    private Buffer buffer;

    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        
    }
    
}