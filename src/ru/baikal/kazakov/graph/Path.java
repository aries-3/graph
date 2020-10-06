package ru.baikal.kazakov.graph;

//TEST
//test 2
<<<<<<< HEAD
//test 3
//test 4
=======
>>>>>>> f66cd14749838e08e04b72cf3c6506b9940833bb

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Path in graph from start vertex to last vertex
 * */
class Path<T> {
    /** List of edges from startVertex to lastVertex */
    private final List<Edge<T>> edges;

    /** First vertex in this path */
    private final Vertex<T> startVertex;

    /** Last vertex in this path */
    private Vertex<T> lastVertex;

    Path(Vertex<T> startVertex){
        edges = new ArrayList<>();
        this.startVertex = startVertex;
        this.lastVertex = startVertex;
    }

    private Path(Path<T> path){
        this.edges = new ArrayList<>(path.edges);
        this.startVertex = path.startVertex;
        this.lastVertex = path.lastVertex;
    }

    /** Add edge to the path */
    Path<T> add(Edge<T> e){

        //if the edge starts with the last vertex of this path, we can add it to this path
        if(e.startsWith(lastVertex)) {

            //add edge to the list of edges
            edges.add(e);

            //change last vertex in this path to the last vertex of the edge
            lastVertex = e.getAnotherVertex(lastVertex);
        }

        return this;
    }

    /** Split this path for each edge in the list */
    List<Path<T>> split(List<Edge<T>> edges){
        return
                edges.
                        stream().
                        map(edge ->
                                new Path<>(this).add(edge)
                        ).
                        collect(Collectors.toList());
    }

    /** Check is this path ends with the vertex */
    boolean endsWith(Vertex<T> v){
        return lastVertex == v;
    }

    /** Get last vertex of this path */
    Vertex<T> getLastVertex(){
        return lastVertex;
    }

    /** Get edges of this path */
    List<Edge<T>> getEdges(){
        return edges;
    }

    @Override
    public String toString() {
        return startVertex + " " + edges.toString() + " " + lastVertex;
    }
}
