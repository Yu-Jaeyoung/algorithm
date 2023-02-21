package src.baekjoon.floyd_warshall.p11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int maxVertexNum = Integer.parseInt(bufferedReader.readLine());
        Floyd floyd = new Floyd(maxVertexNum);
        floyd.makeGraph(maxVertexNum);

        int edgeCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < edgeCount; i++) {
            String lineString = bufferedReader.readLine();
            StringTokenizer token = new StringTokenizer(lineString);
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());
            floyd.addEdge(start, end, weight);
        }

        floyd.floyd(maxVertexNum);
    }

}

class Floyd {

    private int[][] graph;

    Floyd(int maxVertexNum) {
        graph = new int[maxVertexNum][maxVertexNum];
    }


    public void makeGraph(int maxVertexNum) {
        for (int i = 0; i < maxVertexNum; i++) {
            for (int j = 0; j < maxVertexNum; j++) {
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

    public void printGraph(int maxVertexNum) {
        for (int i = 0; i < maxVertexNum; i++) {
            for (int j = 0; j < maxVertexNum; j++) {
                if (graph[i][j] == 0) {
                    System.out.print(graph[i][j] + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            if (i == maxVertexNum - 1) {
                break;
            }
            System.out.println();
        }
    }

    void floyd(int maxVertexNum) {
        System.out.println();
        for (int k = 0; k < maxVertexNum; k++) {
            for (int i = 0; i < maxVertexNum; i++) {
                for (int j = 0; j < maxVertexNum; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        printGraph(maxVertexNum);
    }
}
