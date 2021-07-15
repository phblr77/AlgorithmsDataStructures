package ru.geekbrains.lesson7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException("vertexCount:" + vertexCount);
        }

        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 > vertexCount - 1 || v2 > vertexCount - 1) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        if (v1 == v2) {
            return;
        }
        adjList[v2].add(v1);
        edgeCount++;
    }

    public List<Integer> getAdjList(int vertex) {
        return Collections.unmodifiableList(adjList[vertex]);
    }

    //added
    public LinkedList<Integer> adjList(int v) {
        if (vertexCount < 0 || v > vertexCount - 1) {
            throw new IllegalArgumentException("Vertex number can not be negative.");
        }
        return adjList[v];
    }
}