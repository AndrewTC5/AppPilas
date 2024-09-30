package VistaBuscador;

import java.util.Stack;

public class BuscadorPila {
    private int capacidad, cima;
    private Stack<String> pila = new Stack<>();
    private String info;


    public BuscadorPila() {
        this.pila = pila;
    }

    public void agregar(String info) {
        pila.push(info);
    }

    public String quitar() {
        if (pila.isEmpty()) {
            return "";
        }
        pila.pop();
        return info;
    }

    public Stack<String> getPila() {
        return pila;
    }

    public void setPila(Stack<String> pila) {
        this.pila = pila;
    }

    public boolean vacio(){
        return cima == -1;
    }
    public boolean lleno(){
        return cima == capacidad-1;
    }
}