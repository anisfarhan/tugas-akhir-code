import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Dijkstra {

    // time complexity: O((V + E) log V)
    // space complexity: O(V + E) 
    private static int[] dijkstra(List<List<Pair>> adjList, int src) {
        int n = adjList.size();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.second - b.second;
            }            
        });

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.first;
            int w = curr.second;

            if (w > dist[u]) {
                continue;
            }

            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.first;
                int weight = neighbor.second;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
    public static void main (String[] args) {
        int n, m, src;
        int[] dist;
        List<List<Pair>> adjList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices and edges: ");
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges: ");
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();

            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        System.out.println("Enter the source vertex: ");
        src = sc.nextInt();
        dist = dijkstra(adjList, src);

        System.out.println("Shortest distance from source vertex " + src + " to all other vertices: ");
        for (int i = 1; i <= n; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }
}
