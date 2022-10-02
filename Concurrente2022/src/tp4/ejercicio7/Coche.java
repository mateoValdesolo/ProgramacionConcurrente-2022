package tp4.ejercicio7;

public class Coche implements Runnable {

    private GestorCruce gestor;

    public Coche(GestorCruce gestor) {
        this.gestor = gestor;
    }

    public void run() {
        boolean exito = false;
        int direccion = ((int) (Math.random() * 2 + 1));
        while (!exito) {
            if (direccion == 2) {
                gestor.llegaOeste();
                exito = true;
            } else {
                gestor.llegaNorte();
                exito = true;
            }
            if (exito) {
                gestor.sale(direccion);
            } else {
                esperar();
            }
        }
    }
    
    private void esperar() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            
        }
    }
}
