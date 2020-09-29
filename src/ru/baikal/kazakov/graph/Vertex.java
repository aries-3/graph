package ru.baikal.kazakov.graph;

/**
 * Vertex
 *
 * */
public class Vertex<T> {
    private final T value;

    public Vertex(T v){
        this.value = v;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
