
import java.util.Arrays;
import java.util.Scanner;

class Edge {

    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class BellmanFord {

    public static void bellmanFord(int vertices, Edge[] edges, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains a negative-weight cycle.");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + (dist[i] == Integer.MAX_VALUE ? "Infinity" : dist[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edgesCount = scanner.nextInt();

        Edge[] edges = new Edge[edgesCount];
        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < edgesCount; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        bellmanFord(vertices, edges, source);

        scanner.close();
    }
}


/*
 ### Bellman-Ford Algorithm with Code and Problem Solution

The Bellman-Ford algorithm finds the shortest paths from a single source vertex to all other vertices in a weighted graph, even with negative edge weights. Below is the explanation, code, and solution to a specific example.

---

### **Algorithm**

1. **Initialization**:
   - Create a `dist` array to hold the minimum distance to each vertex.
   - Set `dist[source] = 0` and all other distances to infinity.

2. **Relaxation**:
   - For each edge \( (u, v, w) \) (where \( u \) and \( v \) are vertices and \( w \) is the edge weight), check if \( dist[u] + w < dist[v] \). If true, update \( dist[v] \).

3. **Negative Weight Cycle Detection**:
   - After \( V-1 \) iterations (where \( V \) is the number of vertices), perform one more iteration to check for changes in the distances. If any distance changes, a negative weight cycle exists.

---
Explanation
Initialization:

Start with dist[0] = 0 and all other distances as 
∞
∞.
Relaxation:

After iterating 
𝑉
−
1
V−1 times:
𝑑
𝑖
𝑠
𝑡
[
1
]
=
3
dist[1]=3 (via 
0
→
2
→
1
0→2→1).
𝑑
𝑖
𝑠
𝑡
[
3
]
=
4
dist[3]=4 (via 
0
→
2
→
3
0→2→3).
𝑑
𝑖
𝑠
𝑡
[
4
]
=
7
dist[4]=7 (via 
0
→
2
→
3
→
4
0→2→3→4).
Negative Weight Cycle Detection:

No further updates after 
𝑉
−
1
V−1 iterations indicate no negative-weight cycles.
Time Complexity
Relaxation: 
𝑂
(
𝑉
⋅
𝐸
)
O(V⋅E), where 
𝑉
V is the number of vertices and 
𝐸
E is the number of edges.
Cycle Detection: 
𝑂
(
𝐸
)
O(E).
Total: 
𝑂
(
𝑉
⋅
𝐸
)
O(V⋅E).

Space Complexity
𝑂
(
𝑉
)
O(V): For the dist array.
𝑂
(
𝐸
)
O(E): For the edges list.
Total: 
𝑂
(
𝑉
+
𝐸
)
O(V+E).

Key Observations
Bellman-Ford handles graphs with negative weights effectively.
If a negative-weight cycle exists, the algorithm detects it and stops.
This is useful in financial models, transportation networks, and detecting arbitrage opportunities.

 */
