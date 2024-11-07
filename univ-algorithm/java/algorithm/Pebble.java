import java.util.Arrays;

public class Pebble {
    static int dynamicPebbles(int[][] w) {
        int n = w.length; // 열의 개수
        int[][] peb = new int[n][4];
        for (int p = 1; p <= 4; p++) {
            peb[0][p - 1] = w[0][p - 1];
        }

        System.out.println(Arrays.toString(peb[0]));

        for (int i = 1; i < n; i++) {
            for (int p = 1; p <= 4; p++) {
                int max = Integer.MIN_VALUE;
                for (int q = 1; q <= 4; q++) {
                    if (isCompatible(p, q)) {
                        int tmp = peb[i - 1][q - 1] + w[i][p - 1];
                        if (tmp > max) {
                            max = tmp;
                        }
                    }
                }
                peb[i][p - 1] = max;
            }
            System.out.println(Arrays.toString(peb[i]));
        }

        // System.out.println(Arrays.deepToString(peb));

        return Math.max(peb[n - 1][0], Math.max(peb[n - 1][1], Math.max(peb[n - 1][2], peb[n - 1][3])));
    }

    static boolean isCompatible(int p, int q) {
        switch (p) {
            case 1:
                return q == 2 || q == 3;
            case 2:
                return q == 1 || q == 3 || q == 4;
            case 3:
                return q == 1 || q == 2;
            case 4:
                return q == 2;
            default:
                return false;
        }
    }

    static int[][] calculateW(int[][] table) {
        int[][] w = new int[table.length][4];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < 3; j++) {
                w[i][j] = table[i][j];
            }
            w[i][3] = table[i][0] + table[i][2];
        }

        return w;
    }

    public static void main(String[] args) {
        int[][] pebbles = {
                {6, -8, 11},
                {7, 10, 12},
                {12, 14, 7},
                {-5, 9, 4},
                {5, 7, 8},
                {3, 13, -2},
                {11, 8, 9},
                {3, 5, 4}
        };

        int[][] w = calculateW(pebbles);
        System.out.println("결과 : " + dynamicPebbles(w));
    }

}
