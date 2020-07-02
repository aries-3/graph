package ru.baikal.kazakov.graph.undirected;

import ru.baikal.kazakov.graph.Edge;
import ru.baikal.kazakov.graph.Graph;
import ru.baikal.kazakov.graph.Vertex;

import java.util.ArrayList;

/**
 * Implementation of undirected graph
 * */
public class UndirectedGraph<T> extends Graph<T> {
    public UndirectedGraph(){
        super();
    }

    /**
     * Method for add new edge v1 <-> v2
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

        //create new undirected edge
        Edge<T> e = new UndirectedEdge<>(v1,v2);

        //put the edge to the map for vertex v1
        fromVertexMap.
                computeIfAbsent(v1, k -> new ArrayList<>()).
                add(e);

        //put the edge to the map for vertex v1
        fromVertexMap.
                computeIfAbsent(v2, k -> new ArrayList<>()).
                add(e);
    }
}
