#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void selectionSort(int data[], int length) { // 데이터 개수를 받은 length
    int j, check, tmp;
    for (int i = length - 1; i >= 0; i--) {
        check = i;
        for (j = i - 1; j >= 0; j--) {
            if (data[j] > data[check]) {
                check = j;
            }
        }
        tmp = data[i]; // 맨 마지막 자리 값 저장
        data[i] = data[check]; // 가장 큰값을 맨 마지막에 넣어줌
        data[check] = tmp; // 가장 큰 값의 자리에 맨 마지막 자리값을 넣어줌
    }
}


// 출력 : 정렬 전 데이터, 정렬 후 데이터 출력

int main() {

    int n = 6;
    int *data = (int *) malloc(sizeof(int) * n);

    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        data[i] = rand() % 100;
    }

    printf("정렬 전 배열 : ");

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    printf("\n정렬 후 배열 : ");

    selectionSort(data, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
