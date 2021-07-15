package ru.geekbrains.lesson7;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(10);


        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 8);
        graph.addEdge(2, 9);
        graph.addEdge(2, 6);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(5, 2);

        BreadthFirstPath bfs = new BreadthFirstPath(graph, 7);
        System.out.println(bfs.hasPathTo(8));
        System.out.println(bfs.pathTo(8));

    }


}