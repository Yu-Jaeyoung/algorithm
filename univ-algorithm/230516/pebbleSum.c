#include <stdio.h>
#include <stdlib.h>

#ifndef max
#define max(a, b)  (((a) > (b)) ? (a) : (b))
#endif

int pebbleSum(int length, int matrix[3][length]) {

    int **countedMatrix = (int **) malloc(sizeof(int *) * 4);

    for (int i = 0; i < 4; i++) {
        countedMatrix[i] = (int *) malloc(sizeof(int) * length);
    }

    // 동적 할당된 배열 초기화 진행
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < length; j++) {
            countedMatrix[i][j] = 0;
        }
    }


    // 정상적으로 입력이 넘어오는지 확인을 위한 부분
    printf("\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < length; j++) {
            printf("%2d ", matrix[i][j]);
        }
        printf("\n");
    }

    // 0~2행 0열에 대한 초기화
    for (int i = 0; i < 3; i++) {
        countedMatrix[i][0] = matrix[i][0];
    }

    // 3행의 0열은 입력된 행렬의 0행과 2행의 합을 할당
    countedMatrix[3][0] = matrix[0][0] + matrix[2][0];

    // 테이블 정상 작성 여부 확인을 위한 출력
    printf("\n------------------------\n");
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < length; j++) {
            printf("%2d ", countedMatrix[i][j]);
        }
        printf("\n");
    }
    printf("------------------------\n");

    for (int i = 1; i < length; i++) {
        for (int j = 0; j < 4; j++) {
            if (j == 0)
                countedMatrix[j][i] = matrix[0][i] + max(countedMatrix[1][i - 1], countedMatrix[2][i - 1]);

            if (j == 1)
                countedMatrix[j][i] = matrix[1][i] + max(max(countedMatrix[0][i - 1], countedMatrix[2][i - 1]),
                                                         countedMatrix[3][i - 1]);

            if (j == 2)
                countedMatrix[j][i] = matrix[2][i] + max(countedMatrix[0][i - 1], countedMatrix[1][i - 1]);

            if (j == 3)
                countedMatrix[j][i] = matrix[0][i] + matrix[2][i] + countedMatrix[1][i - 1];
        }
    }

    // 테이블 정상 작성 여부 확인을 위한 출력
    printf("\n--------------------------------\n");
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < length; j++) {
            printf("%3d ", countedMatrix[i][j]);
        }
        printf("\n");
    }
    printf("--------------------------------\n");

    int returnValue = max(max(countedMatrix[0][length - 1], countedMatrix[1][length - 1]),
                          max(countedMatrix[2][length - 1], countedMatrix[1][length - 1]));

    free(countedMatrix[0]);
    free(countedMatrix);

    return returnValue;
}

int main() {
    int inputValue[3][8] = {
            {6,  7,  12, -5, 5, 3,  11, 3},
            {-8, 10, 14, 9,  7, 13, 8,  5},
            {11, 12, 7,  4,  8, -2, 9,  4}
    };

    printf("\nMax = %d", pebbleSum(8, inputValue));
}