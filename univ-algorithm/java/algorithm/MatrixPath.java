public class MatrixPath {
    static int iterMatrixPath(int[][] matrix, int i, int j) {
        int[][] w = new int[matrix.length][matrix[0].length];

        for (int k = 0; k < matrix.length; k++) {
            w[k][0] = 0;
        }
        for (int l = 0; l < matrix[0].length; l++) {
            w[0][l] = 0;
        }
        for (int k = 1; k < matrix.length; k++) {
            for (int l = 1; l < matrix[0].length; l++) {
                // System.out.println("(" + k + "," + l + ") = " + matrix[k][l]);
                w[k][l] = matrix[k][l] + Math.max(w[k - 1][l], w[k][l - 1]);
            }
        }

        printPath(w, i, i);

        return w[i][j];
    }

    static void printPath(int[][] w, int i, int j) {
        StringBuilder path = new StringBuilder();
        path.append("(").append(i).append(", ").append(j).append(")");

        while (i > 1 || j > 1) {
            if (i == 1) {
                j--; // 첫 행에 도달하면 왼쪽으로 이동
            } else if (j == 1) {
                i--; // 첫 열에 도달하면 위쪽으로 이동
            } else if (w[i - 1][j] > w[i][j - 1]) {
                i--; // 위쪽에서 왔을 경우
            } else {
                j--; // 왼쪽에서 왔을 경우
            }
            path.insert(0, "(" + i + ", " + j + ") -> ");
        }

        System.out.println("경로: " + path);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 6, 7, 12, 5},
                {0, 5, 3, 11, 18},
                {0, 7, 17, 3, 3},
                {0, 8, 10, 14, 9}
        };

        System.out.println(iterMatrixPath(matrix, 4, 4));
    }
}
