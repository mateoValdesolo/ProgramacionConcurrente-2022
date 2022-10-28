package tp5.ejercicio2;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantGatosEsperando, cantPerrosEsperando, cantTotalGatos, cantTotalPerros, limite, cantGatosComiendo,cantPerrosComiendo;
    private Semaphore mutex, entrarPrimerAnimal;
    private Semaphore entrarGatos;
    private Semaphore entrarPerros;
    private Semaphore platos;

    public Comedor (int limite, int nroPlatos){
        cantGatosEsperando=0;
        cantPerrosEsperando=0;
        cantGatosComiendo=0;
        cantPerrosComiendo=0;
        cantTotalGatos=0;
        cantTotalPerros=0;
        this.limite=limite;
        mutex= new Semaphore(1);
        entrarPrimerAnimal= new Semaphore(1);
        entrarGatos= new Semaphore(0);
        entrarPerros= new Semaphore(0);
        platos= new Semaphore(nroPlatos);
        


    }


    public void entrar(char tipo) {
        if (tipo=='G'){
            try {
                mutex.acquire();
                cantGatosEsperando++;
                mutex.release();

                System.out.println(Thread.currentThread().getName() +" llega la comedor");

                entrarGatos.acquire();

                mutex.acquire();
                cantGatosEsperando--;
                mutex.release();

                platos.acquire();
                System.out.println(Thread.currentThread().getName() +" accede a un plato");

                mutex.acquire();
                cantGatosComiendo++;
                cantTotalGatos++;
                mutex.release();



        
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        }else{
            try {
                mutex.acquire();
                cantPerrosEsperando++;
                mutex.release();
                System.out.println(Thread.currentThread().getName() +" llega la comedor");

                entrarPerros.acquire();

                mutex.acquire();
                cantPerrosEsperando--;
                mutex.release();

                platos.acquire();
                System.out.println(Thread.currentThread().getName() +" llega la comedor");

                mutex.acquire();
                cantPerrosComiendo++;
                cantTotalPerros++;
                mutex.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            


        }
        
    }

    public void irse(char tipo){
        platos.release();
        System.out.println(Thread.currentThread().getName() +" libera el plato");

        if (tipo=='G'){
            this.irseGato();
        }
        else{
            this.irsePerro();

        }
        System.out.println(Thread.currentThread().getName() +" se va");



    }

    private  void irseGato() {
        try {
            mutex.acquire();
            cantGatosComiendo--;
            
            if (cantGatosComiendo == 0){
                System.out.println(Thread.currentThread().getName() +" era el ultimo comiendo");
                if (cantTotalGatos >= limite) {
                    if (cantPerrosEsperando > 0) {
                        System.out.println(Thread.currentThread().getName() +"  se llego al limite de gatos y hay perros esperando");
                        cantGatosComiendo = 0;
                        // hay perros
                        entrarPerros.release(limite);

                    } else {
                        // no hay perros
                        if (cantGatosEsperando > 0) {
                            System.out.println(Thread.currentThread().getName() +"  se llego al limite de gatos NO HABIA PERROS");
                            // pero si gatos
                            entrarGatos.release();
                        } else {
                            System.out.println(Thread.currentThread().getName() +"  se llego al limite de gatos NO HABIA PERROS NI GATOS");
                            // SETEAR EN 0
                            // no hay niguno de los 2
                            entrarGatos = new Semaphore(0);
                            entrarPrimerAnimal.release();

                        }
                    }
                } else {
                    // si no llegue al limite
                    // si no vienen mas gatos por el momento
                    System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de gatos Y NO HABIA MAS GATOS");
                    if (cantGatosEsperando == 0) {
                        if (cantPerrosEsperando > 0) {
                            System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de gatos Y NO HABIA MAS GATOS PERO SI PERROS");
                            entrarGatos = new Semaphore(0);
                            entrarPerros.release(limite);
                        } else {
                            // si no viene nadie
                            System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de gatos Y NO HABIA MAS GATOS NI PERROS");
                            entrarGatos = new Semaphore(0);
                            entrarPrimerAnimal.release();
                        }

                    }
                }  
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
    
    
      
        

    }
    private  void irsePerro() {
        try {
            mutex.acquire();
            cantPerrosComiendo--;
            if (cantPerrosComiendo == 0){
                System.out.println(Thread.currentThread().getName() +" era el ultimo comiendo");
                if (cantTotalPerros >= limite) {
                    if (cantGatosEsperando > 0) {
                        System.out.println(Thread.currentThread().getName() +"  se llego al limite de perros y hay gatos esperando");
                        cantPerrosComiendo = 0;
                        // hay gatos
                        entrarGatos.release(limite);

                    } else {
                        // no hay gatos
                        if (cantPerrosEsperando > 0) {
                            System.out.println(Thread.currentThread().getName() +"  se llego al limite de perros pero NO HABIA GATOS");
                            // pero si perros
                            entrarPerros.release();
                        } else {
                            // SETEAR EN 0
                            // no hay niguno de los 2
                            System.out.println(Thread.currentThread().getName() +"  se llego al limite de perros pero NO HABIA GATOS NI PERROS" );
                            entrarPerros = new Semaphore(0);
                            entrarPrimerAnimal.release();

                        }
                    }
                } else {
                    // si no llegue al limite y  no vienen mas perros por el momento
                    if (cantPerrosEsperando == 0) {
                        if (cantGatosEsperando > 0) {
                            System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de perros pero SI HABIA GATOS " );
                            entrarPerros = new Semaphore(0);
                            entrarGatos.release(limite);
                        } else {
                            // si no viene nadie
                            System.out.println(Thread.currentThread().getName() +"  NO se llego al limite de perros pero tampoco HABIA GATOS " );
                            entrarPerros = new Semaphore(0);
                            entrarPrimerAnimal.release();
                        }

                    }
                   
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mutex.release();
   
    
      
        

    }

    public void setearPrioridadAnimal(char tipo) {
        if (entrarPrimerAnimal.tryAcquire()) {
            if (tipo == 'G') {
                System.out.println(Thread.currentThread().getName() +  "INICIAN LOS GATOS ");
                entrarGatos.release(limite);
            } else {
    
                System.out.println(Thread.currentThread().getName() + " INICIAN LOS PERROS ");
                entrarPerros.release(limite);
            }

        }
    }

}