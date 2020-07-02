package ru.baikal.kazakov.graph.directed;

import ru.baikal.kazakov.graph.Graph;
import ru.baikal.kazakov.graph.Vertex;

import java.util.ArrayList;

/**
 * Implementation of directed graph
 * */
public class DirectedGraph<T> extends Graph<T> {
    public DirectedGraph(){
        super();
    }

    /**
     * Method for add new edge v1 -> v2
     * */
    @Override
    public void addEdge(Vertex<T> v1, Vertex<T> v2){
        //check the arguments
        if(v1==v2)
            throw new IllegalArgumentException("Both vertexes are the same vertex");
        if(!vertices.contains(v1))
            throw new IllegalArgumentException("Graph does not contain vertex " + v1);
        if(!vertices.contains(v2))
            throw new IllegalArgumentException("Graph does not contain vertex " + v2);

        //create new directed edge and put it to the map for vertex v1
        this.fromVertexMap.computeIfAbsent(v1, k -> new ArrayList<>()).add(new DirectedEdge<>(v1, v2));
    }
}
