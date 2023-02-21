package src.baekjoon.floyd_warshall.p11404;

public class Main {
    public static void main(String[] args) {
        Floyd floyd = new Floyd(5);
        floyd.firstAddEdge(5);
        floyd.addEdge(1,2,2);
        floyd.addEdge(1,3,3);
        floyd.addEdge(1,4,1);
        floyd.addEdge(1,5,10);
        floyd.addEdge(2,4,2);
        floyd.addEdge(3,4,1);
        floyd.addEdge(3,5,1);
        floyd.addEdge(4,5,3);
        floyd.addEdge(3,5,10);
        floyd.addEdge(3,1,8);
        floyd.addEdge(1,4,2);
        floyd.addEdge(5,1,7);
        floyd.addEdge(3,4,2);
        floyd.addEdge(5,2,4);
        floyd.floyd(5);
    }

}

class Floyd {

    private int[][] graph;

    Floyd(int num) {
        graph = new int[num][num];
    }


    public void firstAddEdge(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                graph[i][j] = 100001;
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public void addEdge(int start, int end, int weight) {
        if (graph[start - 1][end - 1] == 0) {
            graph[start - 1][end - 1] = weight;
        } else if (graph[start - 1][end - 1] > weight) {
            graph[start - 1][end - 1] = weight;
        } else {
            return;
        }
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
