package org.example.multihilo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumaConExecutor {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            listaNumeros.add(i);
        }

        int numeroHilos = 4;
        long sumaTotal;
        try (ExecutorService executor = Executors.newFixedThreadPool(numeroHilos)) {

            int mumPorHilo = listaNumeros.size() / numeroHilos;
            List<Future<Long>> futuros = new ArrayList<>();

            for (int i = 0; i < numeroHilos; i++) {
                int inicio = i * mumPorHilo;
                int fin = (i == numeroHilos - 1) ? listaNumeros.size() : inicio + mumPorHilo;

                List<Integer> subLista = listaNumeros.subList(inicio, fin);
                Callable<Long> tarea = () -> {
                    long suma = 0;
                    for (int numero : subLista) {
                        suma += numero;
                    }
                    return suma;
                };
                futuros.add(executor.submit(tarea));
            }

            sumaTotal = 0;
            for (Future<Long> futuro : futuros) {
                try {
                    sumaTotal += futuro.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executor.shutdown();
        }
        System.out.println("La suma total es: " + sumaTotal);
    }
}
