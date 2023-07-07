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
        floyd.makeGraph();

        int edgeCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < edgeCount; i++) {
            String lineString = bufferedReader.readLine();
            StringTokenizer token = new StringTokenizer(lineString);
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());
            floyd.addEdge(start, end, weight);
        }

        floyd.floyd(maxVertexNum);  // 이런식으로 플로이드->플로이드 가 아닌,
                                    // 플로이드 -> run() or 그래프 -> 플로이드 식으로 작성 진행
    }

}

class Floyd { // 무엇을 클래스로 할 것인가에 대한 고민도 필요

    private int[][] graph;

    Floyd(final int maxVertexNum) {
        graph = new int[maxVertexNum][maxVertexNum];
    }


    public void makeGraph() {
        for (int i = 0; i < graph.length; i++) { // 배열을 활용하므로 향상된 for문으로 변경할 수 있음
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = 100001;
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public void addEdge(int start, int end, int weight) { // 예외 조건을 처리 한 후 작성하는 방법이 가독성이 좋음
        if (graph[start - 1][end - 1] < weight) {
            return;
        }
        graph[start - 1][end - 1] = weight;
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