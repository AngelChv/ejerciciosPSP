package org.example.prioridadesHilos;

class TareaPrioridad implements Runnable {
    private String nombre;

    public TareaPrioridad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            long x = 0;
            for (int j = 0; j < 5000; j++) {
                x *= i * j; // aumentar carga del hilo
            }
            System.out.println(nombre + " ejecutando iteración " + i);
        }
        System.out.println(nombre + " finalizó.");
    }
}
