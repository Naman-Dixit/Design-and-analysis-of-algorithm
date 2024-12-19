
import java.util.*;

class Graph {

    private final int vertices;
    private final List<List<Node>> adjacencyList;

    static class Node implements Comparable<Node> {

        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int weight) {
        adjacencyList.get(src).add(new Node(dest, weight));
        adjacencyList.get(dest).add(new Node(src, weight)); // For undirected graph
    }

    void dijkstra(int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        boolean[] visited = new boolean[vertices];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + (dist[i] == Integer.MAX_VALUE ? "Infinity" : dist[i]));
        }
    }
}

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edgesCount = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < edgesCount; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        graph.dijkstra(source);

        scanner.close();
    }
}

/*
 
Algorithm
Initialization:

Create a dist array to hold the shortest distances from the source.
Set dist[source] = 0 and all other distances to infinity.
Use a priority queue (min-heap) to efficiently select the next vertex with the smallest tentative distance.
Relaxation:

Extract the vertex with the smallest distance from the priority queue.
For each adjacent vertex, calculate the tentative distance through the current vertex. If it’s smaller than the known distance, update the distance and add the vertex to the priority queue.
Termination:

Repeat until all vertices are processed or the priority queue is empty.

 */
