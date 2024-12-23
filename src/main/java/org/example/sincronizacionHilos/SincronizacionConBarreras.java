package org.example.sincronizacionHilos;

import java.util.concurrent.CyclicBarrier;

public class SincronizacionConBarreras {
    public static void main(String[] args) {
        final int NUM_HILOS = 5;
        Contador recurso = new Contador();
        CyclicBarrier barrera = new CyclicBarrier(NUM_HILOS,
                () -> System.out.println("Todos los hilos llegaron a la barrera."));

        Runnable tarea = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    recurso.incrementar();
                    System.out.println(Thread.currentThread().getName() + " incrementó el contador.");
                }
                barrera.await(); // Espera a que todos los hilos lleguen aquí
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < NUM_HILOS; i++) {
            new Thread(tarea).start();
        }
    }
}