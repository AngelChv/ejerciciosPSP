package org.example.prioridadesHilos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioridadesConScheduler {
    public static void main(String[] args) {
        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3)) {

            Runnable tarea1 = () -> System.out.println("Hilo-1 ejecutando.");
            Runnable tarea2 = () -> System.out.println("Hilo-2 ejecutando.");
            Runnable tarea3 = () -> System.out.println("Hilo-3 ejecutando.");

            scheduler.scheduleAtFixedRate(tarea1, 0, 3, TimeUnit.SECONDS); // Prioridad baja
            scheduler.scheduleAtFixedRate(tarea2, 0, 2, TimeUnit.SECONDS); // Prioridad media
            scheduler.scheduleAtFixedRate(tarea3, 0, 1, TimeUnit.SECONDS); // Prioridad alta
        }
    }
}