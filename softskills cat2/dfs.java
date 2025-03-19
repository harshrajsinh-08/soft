import java.util.*;

public class dfs {
    private LinkedList<Integer>[] adjLists;
    private boolean[] visited;

    dfs(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjLists[vertex]) {
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String[] args) {
        dfs g = new dfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Depth First Traversal:");
        g.DFS(2);
    }
}