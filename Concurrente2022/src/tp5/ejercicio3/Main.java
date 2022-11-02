package tp5.ejercicio3;

import java.util.Scanner;

public class Main {
   

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese la cantidad de perros");
        int cantPerros= s.nextInt();
        System.out.println("Ingrese la cantidad de gatos");
        int cantGatos= s.nextInt();


        Thread animales[]= new Thread[cantPerros+cantGatos];

        int limite, cantPlatos;

        System.out.println("Ingrese el limite ");
        limite= s.nextInt();
        System.out.println("Ingrese la cantidad de platos");
        cantPlatos= s.nextInt();

        Comedor c= new Comedor(limite, cantPlatos);

        int j=0;

        for (int i=0;i<cantGatos+cantPerros;i++){
            if (i<cantGatos){
                animales[i]= new Thread(new Animal('G',c), "Gato "+i);
            }
            else{

                animales[i]= new Thread(new Animal('P',c), "Perro "+j);
                j++;
            }
        }
        for (int i=0;i<cantGatos+cantPerros;i++){
            animales[i].start();
        }
        


    }
}