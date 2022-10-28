package tp5.ejercicio7;

import java.util.Random;
//que pasa si mientras algunos estan esperando para hacer un acquire del semPaso del puente el hilo hace el cambio
public class Babuino implements Runnable{
    private Cuerda p;
    public Babuino (Cuerda p){
        this.p=p;
    }
    public void run (){
        Random r= new Random();
        if (r.nextInt(2)==0){
            System.out.println(Thread.currentThread().getName() + " QUIERE PASAR DE LA IZQ");
            p.pasar('I');
        }
        else{
            System.out.println(Thread.currentThread().getName() + " QUIERE PASAR DE LA DER");
            p.pasar('D');
        }
        System.out.println("PASANDOOOOOOO");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.irse();


    }

}