package src.baekjoon.floyd_warshall.p11404;

public class Main {

}

class Floyd {

    private int[][] graph;

    Floyd(int num) {
        graph = new int[num][num];
    }

    public void addEdge(int start, int end, int weight) {
        graph[start - 1][end - 1] = weight;
    }

    public void printGraph(int maxNode) {
        for (int i = 0; i < maxNode; i++) {
            for (int j = 0; j < maxNode; j++) {
                if (graph[i][j] == 0) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    void floyd(int maxNode) {
        printGraph(maxNode);
        System.out.println();
        for (int k = 0; k < maxNode; k++) {
            for (int i = 0; i < maxNode; i++) {
                for (int j = 0; j < maxNode; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        printGraph(maxNode);
    }
}
