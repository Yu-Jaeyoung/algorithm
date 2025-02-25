import java.util.LinkedList;

public class Graph<E> {
    private final E[] values;
    private final LinkedList<Integer>[] adjacentList;
    private final int vertexCount;


    // {"철수", "영희", ... }
    public Graph(E[] values) {
        this.values = values;
        vertexCount = values.length;
        adjacentList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacentList[i] = new LinkedList<>();
        }
    }
    // ----------------------- 연결 리스트 시작점까지 생성 완료

    public void addEdge(int v, int w) {
        adjacentList[v].add(w);
        adjacentList[w].add(v);
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

        for (Integer w: adjacentList[vertex]) {
            if (!visited[w]) {
                dfsInternal(w, visited);
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
            for(Integer w: adjacentList[v]) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
        System.out.println();
    }

    public void print() {
        for(int i = 0; i < vertexCount; i++) {
            LinkedList<Integer> list = adjacentList[i];
            for(Integer index: list) {
                System.out.print(values[index] + "  ");
            }
            System.out.println();
        }
    }
}
