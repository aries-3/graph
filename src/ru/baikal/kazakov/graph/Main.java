package ru.baikal.kazakov.graph;

import ru.baikal.kazakov.graph.directed.DirectedGraph;

/***/
public class Main {

    /***/
    public static void main(String[] args) {
        //Graph<Integer> graph = new UndirectedGraph<>();
        Graph<Integer> graph = new DirectedGraph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        Vertex<Integer> v7 = new Vertex<>(7);
        Vertex<Integer> v8 = new Vertex<>(8);
        Vertex<Integer> v9 = new Vertex<>(9);
        Vertex<Integer> v10 = new Vertex<>(10);
        Vertex<Integer> v11 = new Vertex<>(11);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);
        graph.addVertex(v10);
        graph.addVertex(v11);

        graph.addEdge(v0, v1);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v4);



        graph.addEdge(v4, v5);
        graph.addEdge(v4, v6);
        graph.addEdge(v5, v6);
        graph.addEdge(v2, v7);
        graph.addEdge(v7, v8);
        graph.addEdge(v8, v9);
        graph.addEdge(v9, v10);
        graph.addEdge(v10, v7);
        graph.addEdge(v10, v11);
        graph.addEdge(v6, v8);

        System.out.println(graph.getPath(v0, v11));
    }
}

/*
Simple Graph lib:
 
Should support 2 types of graphs - directed and undirected with 3 operations:
 addVertex - adds vertex to the graph
 addEdge - adds edge to the graph
 getPath - returns a list of edges between 2 vertices (path doesn’t have to be optimal)
 Vertices should be of a user defined type.
 Questions to be ready to answer (don’t have to implement): (можно не писать код, быть
готовым ответить на эти вопросы)
 Add weighted edges support in your lib.
Add traverse function that will take a user defined function and apply it on every vertex of the
graph.
Make you graphs thread safe.
* */
