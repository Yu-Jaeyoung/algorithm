import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int end; // 정점 인덱스
    int weight; // 가중치

    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class WeightedGraph<E> {
    private final E[] values;
    private final LinkedList<Edge>[] adjacentList;
    private final int vertexCount;


    // {"철수", "영희", ... }
    public WeightedGraph(E[] values) {
        this.values = values;
        vertexCount = values.length;
        adjacentList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }
    // ----------------------- 연결 리스트 시작점까지 생성 완료

    public void addEdge(int v, int w, int weight) {
        adjacentList[v].add(new Edge(w, weight));
        adjacentList[w].add(new Edge(v, weight));
    }

    // DFS (Depth First Search), 깊이 우선 탐색
    public void dfs(int start) {
        // 방문 여부를 저장
        boolean[] visited = new boolean[vertexCount];
        dfsInternal(start, visited);
        System.out.println();
    }

    private void dfsInternal(int vertex, boolean[] visited) {
        visited[vertex] = true; // vertex 정점 방문 표시
        System.out.print(vertex + ":" + values[vertex] + "  ");

        for (Edge edge : adjacentList[vertex]) {
            if (!visited[edge.end]) {
                dfsInternal(edge.end, visited);
            }
        }
    }

    // BFS (Breadth First Search), 넓이 우선 탐색
    public void bfs(int start) {
        boolean[] visited = new boolean[vertexCount];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true; // 시작 정점 방문 완료 표시
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + ":" + values[v] + "  ");
            for (Edge edge : adjacentList[v]) {
                if (!visited[edge.end]) {
                    visited[edge.end] = true;
                    queue.add(edge.end);
                }
            }
        }
        System.out.println();
    }

    void primMST() {
        int[] costs = new int[vertexCount];
//        for (int i = 0; i < vertexCount; i++) {
//            costs[i] = Integer.MAX_VALUE;
//        }

        Arrays.fill(costs, Integer.MAX_VALUE);
        HashSet<Integer> noVisited = new HashSet<>();
        for (int i = 0; i < vertexCount; i++) {
            noVisited.add(i);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int mstWeight = 0;

        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.end;
            if (!noVisited.contains(u)) {
                continue;
            }
            noVisited.remove(u);
            mstWeight += edge.weight;
            System.out.print(values[u] + ":" + edge.weight + "  ->  ");

            for (Edge e : adjacentList[u]) {
                int v = e.end;
                if (noVisited.contains(v) && e.weight < costs[v]) {
                    costs[v] = e.weight;
                    pq.add(new Edge(v, e.weight));
                }
            }
        }

        System.out.println("primMST의 최소 비용은 " + mstWeight);
    }

    public void dijkstra(int start) {
        int[] distance = new int[vertexCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
        HashSet<Integer> noVisited = new HashSet<>();
        for (int i = 0; i < vertexCount; i++) {
            noVisited.add(i);
        }

        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.end;
            System.out.print(values[u] + ":" + distance[u] + " -> ");
            noVisited.remove(u);

            for (Edge e : adjacentList[u]) {
                int v = e.end;
                int weight = e.weight;

                int dist1 = distance[u] + weight;
                int dist2 = distance[v];

                if (dist1 < dist2) {
                    distance[v] = dist1;
                }

                int newDistance = distance[u] + weight;
                if (noVisited.contains(v) && newDistance < distance[v]) {
                    distance[v] = newDistance;
                    // pq.add(new Edge());
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertexCount; i++) {
            LinkedList<Edge> list = adjacentList[i];
            for (Edge edge : list) {
                System.out.print(values[edge.end] + "  ");
            }
            System.out.println();
        }
    }
}
