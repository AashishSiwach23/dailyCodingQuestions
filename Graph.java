import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS traversal from a given source vertex
    void BFS(int v) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        System.out.println("Breadth-First Traversal (starting from vertex " + v + "):");

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (Integer neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Graph graph = new Graph(7); // Create a graph with 7 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        int startingVertex = 0; // Choose the starting vertex for BFS

        graph.BFS(startingVertex);
    }
}
