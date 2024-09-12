#include <stdio.h>
#include <stdlib.h>

#ifndef max
#define max(a, b)  (((a) > (b)) ? (a) : (b))
#endif

int maxMatrixPath(int length, int matrix[length][length]) {

    // 입력 받은 행렬 출력
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    int **countedMatrix = (int **) malloc(sizeof(int *) * length);

    for (int i = 0; i < length; i++) {
        countedMatrix[i] = (int *) malloc(sizeof(int) * length);
    }

    // 동적 할당된 배열 초기화 진행
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            countedMatrix[i][j] = 0;
        }
    }

    // 시작점 초기화
    countedMatrix[0][0] = matrix[0][0];

    // 0번 행에 대한 초기화
    for (int i = 1; i < length; i++) {
        countedMatrix[0][i] = countedMatrix[0][i - 1] + matrix[0][i];
    }

    // 0번 열에 대한 초기화
    for (int i = 1; i < length; i++) {
        countedMatrix[i][0] = countedMatrix[i - 1][0] + matrix[i][0];
    }

    // 최대 경로 구하기
    for (int i = 1; i < length; i++) {
        for (int j = 1; j < length; j++) {
            countedMatrix[i][j] = matrix[i][j] + max(countedMatrix[i - 1][j], countedMatrix[i][j - 1]);
        }
    }

    // 최대 경로로 초기화 된 행렬 출력
    printf("\n");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", countedMatrix[i][j]);
        }
        printf("\n");
    }

    int returnValue = countedMatrix[length - 1][length - 1];


    int **maxLengthMatrix = (int **) malloc(sizeof(int *) * length);
    for (int i = 0; i < length; i++) {
        maxLengthMatrix[i] = (int *) malloc(sizeof(int) * length);
    }

    maxLengthMatrix = countedMatrix;

    // 최장 거리 경로 구하는 과정
    for (int i = length - 1, j = length - 1; i != 0 && j != 0;) {
        int max_value = max(maxLengthMatrix[i - 1][j], maxLengthMatrix[i][j - 1]);

        if (max_value == maxLengthMatrix[i - 1][j]) {
            maxLengthMatrix[i][j - 1] = 0;

            int saved_j = j - 1;
            for (int k = saved_j; k >= 0; k--) {
                maxLengthMatrix[i][k] = 0;
            }
            i = i - 1;

        } else if (max_value == maxLengthMatrix[i][j - 1]) {
            maxLengthMatrix[i - 1][j] = 0;

            int saved_i = i - 1;
            for (int k = saved_i; k >= 0; k--) {
                maxLengthMatrix[k][j] = 0;
            }
            j = j - 1;

        }
    }


    printf("\n");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", maxLengthMatrix[i][j]);
        }
        printf("\n");
    }

    printf("\n");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            if (maxLengthMatrix[i][j] != 0) {
                printf("(%d,%d) ", i, j);
            }
        }
    }
    printf("\n");

    free(countedMatrix[0]);
    free(countedMatrix);

    return returnValue;
}

int main() {

    int inputValue[4][4] = {
            {6, 7,  12, 5},
            {5, 3,  11, 18},
            {7, 17, 3,  3},
            {8, 10, 14, 9}
    };

    printf("\nMax = %d", maxMatrixPath(4, inputValue));
}