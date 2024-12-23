package org.example.prioridadesHilos;

public class PrioridadesHilos {
    public static void main(String[] args) {
        // Crear instancias de Runnable
        TareaPrioridad tarea1 = new TareaPrioridad("Hilo-1");
        TareaPrioridad tarea2 = new TareaPrioridad("Hilo-2");
        TareaPrioridad tarea3 = new TareaPrioridad("Hilo-3");

        // Crear hilos
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);
        Thread hilo3 = new Thread(tarea3);

        // Asignar prioridades
        hilo1.setPriority(Thread.MIN_PRIORITY); // Prioridad mínima
        hilo2.setPriority(Thread.NORM_PRIORITY); // Prioridad normal (por defecto)
        hilo3.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperar que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los hilos han finalizado.");
    }
}
