package ru.baikal.kazakov.graph.undirected;

import ru.baikal.kazakov.graph.Edge;
import ru.baikal.kazakov.graph.Vertex;

/**
 * Implementation of undirected edge
 * */
public class UndirectedEdge<T> extends Edge<T> {
    public UndirectedEdge(Vertex<T> v1, Vertex<T> v2){
        super(v1, v2);
    }

    /** Check is the edge starts with the vertex */
    @Override
    protected boolean startsWith(Vertex<T> v){
        return v1 == v || v2 == v;
    }

    @Override
    public String toString() {
        return v1 + "<->" + v2;
    }
}
