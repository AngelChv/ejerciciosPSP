package org.example.multihilo;

import java.util.ArrayList;
import java.util.List;

public class SumaMultihilo {
    public static void main(String[] args) {
        // Generar una lista de números de ejemplo
        List<Integer> listaNumeros = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            listaNumeros.add(i); // Números del 1 al 1.000.000
        }

        // Número de hilos que queremos usar
        final int numeroHilos = 4;

        // Dividir la lista en partes iguales
        final int numPorHilo = listaNumeros.size() / numeroHilos;
        List<Thread> hilos = new ArrayList<>();
        List<SumaParcial> tareas = new ArrayList<>();

        for (int i = 0; i < numeroHilos; i++) {
            final int inicio = i * numPorHilo;
            final int fin = (i == numeroHilos - 1) ? listaNumeros.size() : inicio + numPorHilo;

            List<Integer> subLista = listaNumeros.subList(inicio, fin);
            SumaParcial tarea = new SumaParcial(subLista);
            tareas.add(tarea);

            Thread hilo = new Thread(tarea);
            hilos.add(hilo);
            hilo.start();
        }

        // Esperar que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Calcular el resultado total sumando los resultados parciales
        long sumaTotal = 0;
        for (SumaParcial tarea : tareas) {
            sumaTotal += tarea.getResultado();
        }

        System.out.println("La suma total es: " + sumaTotal);
    }
}
