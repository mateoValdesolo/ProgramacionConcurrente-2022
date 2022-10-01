package tp4.ejercicio4;

import java.util.concurrent.Semaphore;

public class CentroImpresion {

        private Semaphore impresoraA[];
        private Semaphore impresoraB[];
        private int cantA;
        private int cantB;

        public CentroImpresion(int cantA, int cantB) {
                this.cantA = cantA;
                this.cantB = cantB;
                impresoraA = new Semaphore[cantA];
                impresoraB = new Semaphore[cantB];
                for (int i = 0; i < cantA; i++) {
                        impresoraA[i] = new Semaphore(1, true);
                }
                for (int i = 0; i < cantB; i++) {
                        impresoraB[i] = new Semaphore(1, true);
                }
        }

        public void imprimirA(int num) {
                try {
                        impresoraA[num].acquire();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        public void imprimirB(int num) {
                try {
                        impresoraB[num].acquire();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        public void dejarA(int num) {
                impresoraA[num].release();
        }

        public void dejarB(int num) {
                impresoraB[num].release();
        }

        public int getCantA() {
                return cantA;
        }

        public int getCantB() {
                return cantB;
        }
}