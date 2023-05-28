#include <stdio.h>
#include <stdlib.h>

#ifndef min
#define min(a, b)  (((a) < (b)) ? (a) : (b))
#endif

int matrixChain(int matrixCount) {

    // p[] 배열 동젹 할당
    int *rowColumnArray = (int *) malloc(sizeof(int) * matrixCount + 1);

    // p[] 배열 초기화
    for (int i = 0; i < matrixCount + 1; i++) {
        printf("rowColumnArray[%d]의 값 입력 : ", i);
        scanf("%d", &rowColumnArray[i]);
    }

    // m[] 행렬 동적 할당
    int **minTimesCountMatrix = (int **) malloc(sizeof(int *) * matrixCount);

    for (int i = 0; i < matrixCount + 1; i++) {
        minTimesCountMatrix[i] = (int *) malloc(sizeof(int) * matrixCount);
    }

    // m[] 행렬의 중앙 대각선 초기화
    for (int i = 0; i < matrixCount; i++) {
        minTimesCountMatrix[i][i] = 0;
    }

    int minTimesCount;

    for (int r = 1; r < matrixCount; r++) {
        for (int i = 0, j = r; i < matrixCount - r && j < matrixCount; i++, j++) {
            if (i + 1 == j) {
                minTimesCount = rowColumnArray[i] * rowColumnArray[i + 1] * rowColumnArray[i + 2];
                minTimesCountMatrix[i][j] = minTimesCount;
            } else {
                minTimesCount = min(minTimesCountMatrix[i][j - 1], minTimesCountMatrix[i + 1][j]);
                if (minTimesCount == minTimesCountMatrix[i][j - 1]) { // 왼쪽
                    minTimesCountMatrix[i][j] =
                            minTimesCount + (rowColumnArray[i] * rowColumnArray[j] * rowColumnArray[j + 1]);
                } else { // 아래
                    minTimesCountMatrix[i][j] =
                            minTimesCount + (rowColumnArray[i] * rowColumnArray[i + 1] * rowColumnArray[j + 1]);
                }
            }
        }
    }

//    minTimesCountMatrix[][] 출력
//    printf("\n");
//    for (int r = 1; r < matrixCount; r++) {
//        for (int i = 0, j = r; i < matrixCount - r && j < matrixCount; i++, j++) {
//            printf("minTimesCountMatrix[%d][%d] = %d\n", i, j, minTimesCountMatrix[i][j]);
//        }
//    }

    return minTimesCountMatrix[0][matrixCount - 1];
}


int main() {

    int matrixCount;
    printf("행렬의 개수 입력 : ");
    scanf("%d", &matrixCount);

    printf("최소 곱셈 수 = %d", matrixChain(matrixCount));

    return 0;
}