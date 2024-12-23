package org.example.sincronizacionHilos;

public class SincronizacionHilos {
    public static void main(String[] args) {
        Contador contador = new Contador();

        // Crear dos hilos que comparten el mismo recurso
        Thread hilo1 = new Thread(new Tarea(contador), "Hilo-1");
        Thread hilo2 = new Thread(new Tarea(contador), "Hilo-2");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + contador.getCuenta());
    }
}
