package org.example.sincronizacionHilos;

/// Tarea que utiliza el Contador compartido
public class Tarea implements Runnable {
    private Contador contador;

    public Tarea(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            contador.incrementar();
            try {
                Thread.sleep(100); // Simula una operación que lleva tiempo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
