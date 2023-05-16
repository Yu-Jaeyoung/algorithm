/*
#include <stdio.h>
#include <stdlib.h>

#ifndef max
#define max(a, b)  (((a) > (b)) ? (a) : (b))
#endif

int maxMatrixPath(int length, int matrix[length][length]) {

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

    // 정상적으로 입력이 넘어오는지 확인을 위한 부분
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
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

    // 정상적으로 초기화되었는지 확인을 위한 부분
    printf("\n");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", countedMatrix[i][j]);
        }
        printf("\n");
    }




    // 최대 경로 구하기
    for (int i = 1; i < length; i++) {
        for (int j = 1; j < length; j++) {
            countedMatrix[i][j] = matrix[i][j] + max(countedMatrix[i - 1][j], countedMatrix[i][j - 1]);
        }
    }

    // 최장 경로 정상 초기화 체크용
    printf("\n");
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            printf("%d ", countedMatrix[i][j]);
        }
        printf("\n");
    }


    int returnValue = countedMatrix[length - 1][length - 1];

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

    printf("Max = %d", maxMatrixPath(4, inputValue));
}
*/
