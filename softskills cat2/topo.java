import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;
    private int vertices;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void createEdge(int u, int v) {
        this.adjacencyList.get(u).add(v);
    }

    public void topologicalSort() {
        int[] totalIndegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j : adjacencyList.get(i)) {
                totalIndegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (totalIndegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedNodes = 0;
        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int i : adjacencyList.get(u)) {
                totalIndegree[i]--;
                if (totalIndegree[i] == 0) {
                    queue.add(i);
                }
            }
            visitedNodes++;
        }

        if (visitedNodes != vertices) {
            System.out.println("Cycle detected! Topological sorting not possible.");
        } else {
            System.out.println("Topological Sort: " + order);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.createEdge(5, 2);
        g.createEdge(5, 0);
        g.createEdge(4, 0);
        g.createEdge(4, 1);
        g.createEdge(2, 3);
        g.createEdge(3, 1);

        System.out.println("Performing Topological Sort:");
        g.topologicalSort();
    }
}