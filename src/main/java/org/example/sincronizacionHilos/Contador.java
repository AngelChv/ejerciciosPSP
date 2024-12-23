package org.example.sincronizacionHilos;

/// Representa el recurso compartido
public class Contador {
    private int cuenta = 0;

    /// Synchronized evita condiciones de carrera asegurando que un solo hilo pueda ejecutarlo a la vez.
    public synchronized void incrementar() {
        cuenta++;
        System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + cuenta);
    }

    public int getCuenta() {
        return cuenta;
    }
}
