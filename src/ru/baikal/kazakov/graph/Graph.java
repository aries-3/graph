package ru.baikal.kazakov.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class for abstract graph
 * */
public abstract class Graph<T> {

    /**
     * Set of vertexes in this graph
     * */
    protected final Set<Vertex<T>> vertices;

    /**
     * Map for determine to which edge we can run from the vertex
     * */
    protected final Map<Vertex<T>, List<Edge<T>>> fromVertexMap;

    public Graph(){
        this.vertices = new HashSet<>();
        this.fromVertexMap = new HashMap<>();
    }

    //method for add the vertex
    public void addVertex(Vertex<T> v){
        this.vertices.add(v);
    }

    //abstract method for add the edge between two vertexes
    public abstract void addEdge(Vertex<T> v1, Vertex<T> v2);

    //find path between two vertexes
    public List<Edge<T>> getPath(Vertex<T> v1, Vertex<T> v2){
        //if the graph does not contain v1 or v2 returns empty list
        if(!vertices.contains(v1) || !vertices.contains(v2))
            return new ArrayList<>();

        //set for collect processed edges
        Set<Edge<T>> processedEdges = new HashSet<>();

        //list of paths to be processed in current path
        List<Path<T>> currentStepPaths;

        //list of paths to be processed in next step
        List<Path<T>> nextStepPaths = new ArrayList<>();

        //add empty path from start vertex
        nextStepPaths.add(new Path<>(v1));

        for(;;) {
            //flag for breaking the circle
            boolean hasNewPaths = false;

            //assign next paths list to the current paths list
            currentStepPaths = nextStepPaths;

            nextStepPaths = new ArrayList<>();

            for (Path<T> path : currentStepPaths) {

                //if path ends with finish vertex, then the path has already find
                if (path.endsWith(v2))
                    return path.getEdges();

                //find all not processed edges which runs from the last vertex of the current path
                List<Edge<T>> newEdges = fromVertexMap.getOrDefault(path.getLastVertex(), new ArrayList<>()).stream().filter(edge -> {
                    if (!processedEdges.contains(edge)) {
                        processedEdges.add(edge);
                        return true;
                    }
                    else {
                        return false;
                    }
                }).collect(Collectors.toList());

                //for each new edge split current path
                List<Path<T>> newPaths = path.split(newEdges);

                if(newPaths.size() > 0)
                    hasNewPaths = true;

                //add new paths to the list of paths for next step
                nextStepPaths.addAll(newPaths);
            }

            //if we don't find any new path we need to stop the circle
            if(!hasNewPaths)
                break;
        }

        //return empty list because we can not find any path
        return new ArrayList<>();
    }
}
