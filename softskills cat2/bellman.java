public class bellman {
    static class Graph {
        class Edge {
            int src, dest, weight;
            Edge(int src, int dest, int weight) {
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }

        int V, E;
        Edge[] edges;

        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[e];
        }

        void bellmanFord(int src) {
            int[] dist = new int[V];
            for (int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;
            dist[src] = 0;

            for (int i = 1; i < V; i++) {
                for (int j = 0; j < E; j++) {
                    int u = edges[j].src;
                    int v = edges[j].dest;
                    int w = edges[j].weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                        dist[v] = dist[u] + w;
                }
            }

            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
                }
            }

            printSolution(dist);
        }

        void printSolution(int[] dist) {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5, E = 7;
        Graph graph = new Graph(V, E);

        graph.edges[0] = graph.new Edge(0, 1, 5);
        graph.edges[1] = graph.new Edge(0, 2, 4);
        graph.edges[2] = graph.new Edge(1, 3, 3);
        graph.edges[3] = graph.new Edge(2, 1, 6);
        graph.edges[4] = graph.new Edge(3, 2, 2);
        graph.edges[5] = graph.new Edge(1, 4, -4);
        graph.edges[6] = graph.new Edge(4, 2, 2);

        graph.bellmanFord(0); // Source vertex is 0
    }
}