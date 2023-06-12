#include <stdio.h>

#define ROW 3
#define COL 3

int max(int a, int b, int c) {
    if (a > b && a > c)
        return a;
    else if (b > a && b > c)
        return b;
    else
        return c;
}

int matrixPathAdvanced(int matrix[ROW][COL]) {
    int dp[ROW][COL]; // DP 테이블

    // 초기값 설정
    dp[0][0] = matrix[0][0];

    // 첫 번째 열의 최대 경로 합 계산
    for (int i = 1; i < ROW; i++) {
        dp[i][0] = dp[i - 1][0] + matrix[i][0];
    }

    // 첫 번째 행의 최대 경로 합 계산
    for (int j = 1; j < COL; j++) {
        dp[0][j] = dp[0][j - 1] + matrix[0][j];
    }

    // 나머지 칸의 최대 경로 합 계산
    for (int i = 1; i < ROW; i++) {
        for (int j = 1; j < COL; j++) {
            dp[i][j] = matrix[i][j] + max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
        }
    }

    for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
            printf("%d ", dp[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    return dp[ROW - 1][COL - 1]; // 우하단 칸의 최대 경로 합 반환
}

int main() {
    int matrix[ROW][COL] = {{1, 3, 1},
                            {2, 4, 1},
                            {5, 2, 1}};

    int maxPathSum = matrixPathAdvanced(matrix);
    printf("Maximum path sum: %d\n", maxPathSum);

    return 0;
}
