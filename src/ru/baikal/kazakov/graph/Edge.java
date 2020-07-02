package ru.baikal.kazakov.graph;

/**
 * Abstract edge
 * */
public abstract class Edge<T> {
    /** Vertex v1 */
    protected final Vertex<T> v1;

    /** Vertex v2 */
    protected final Vertex<T> v2;

    protected Edge(Vertex<T> v1, Vertex<T> v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    /** Get another vertex of the edge */
    Vertex<T> getAnotherVertex(Vertex<T> v){
        if(v1 == v)
            return v2;

        if(v2 == v)
            return v1;

        throw new IllegalArgumentException("Edge " + this + " does not contain vertex " + v);
    }

    /** Check is the edge starts with the vertex */
    protected abstract boolean startsWith(Vertex<T> v);
}
