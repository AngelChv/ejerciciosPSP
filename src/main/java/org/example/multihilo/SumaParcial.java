package org.example.multihilo;
import java.util.List;

class SumaParcial implements Runnable {
    private final List<Integer> numeros;
    private long resultado;

    public SumaParcial(List<Integer> numeros) {
        this.numeros = numeros;
        this.resultado = 0;
    }

    @Override
    public void run() {
        for (int numero : numeros) {
            resultado += numero;
        }
    }

    public long getResultado() {
        return resultado;
    }
}
