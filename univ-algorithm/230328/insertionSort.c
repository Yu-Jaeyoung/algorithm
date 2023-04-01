#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void insertionSort(int data[], int length) {
    int i, j, key;
    for (i = 1; i < length; i++) {
        key = data[i];
        for (j = i - 1; j >= 0 && data[j] > key; j--) {
            data[j + 1] = data[j];
        }
        data[j + 1] = key;
    }
}

int main() {

    int n;
    printf("랜덤 수의 개수를 입력하시오. : ");

    scanf("%d", &n);

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

    insertionSort(data, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}