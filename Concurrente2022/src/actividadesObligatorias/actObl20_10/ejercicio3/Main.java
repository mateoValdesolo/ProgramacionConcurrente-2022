package actividadesObligatorias.actObl20_10.ejercicio3;

import java.util.Scanner;

/**
 *
 * @author  GRUPO 7
 * TORRES, ANTONELLA
 * VALDESOLO, MATEO
 * RIVERA, MALENA
 */
public class Main {
     public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de hilos durmientes");
        int n=s.nextInt();

        Reloj r= new Reloj(n);
        Thread hilosDurmientes[]= new Thread[n];
        Thread controlReloj= new Thread(new ControlReloj(r));

        for(int i=0;i<hilosDurmientes.length;i++) {
            hilosDurmientes[i]= new Thread(new Trabajador(r,i), "Trabajador "+i);
        }
        for(int i=0;i<hilosDurmientes.length;i++) {
            hilosDurmientes[i].start();;
        }
        controlReloj.start();

       }
    
}