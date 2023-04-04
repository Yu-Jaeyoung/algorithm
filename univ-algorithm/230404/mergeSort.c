#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void merge(int data[], int left, int middle, int right) {

    int *tmp = (int *) malloc(sizeof(int) * (right - left + 1));

    int i, j, k, l;
    i = left;
    j = middle + 1;
    k = left;

    while (i <= middle && j <= right) {
        if (data[i] <= data[j]) {
            tmp[k++] = data[i++];
        } else {
            tmp[k++] = data[j++];
        }
    }

    if (i > middle) {
        for (l = j; l <= right; l++) {
            tmp[k++] = data[l];
        }
    } else {
        for (l = i; l <= middle; l++) {
            tmp[k++] = data[l];
        }
    }

    for (l = left; l <= right; l++) {
        data[l] = tmp[l];
    }

    free(tmp);
}

void mergeSort(int data[], int left, int right) {

    if (left < right) {
        int middle = (left + right) / 2;
        mergeSort(data, left, middle);
        mergeSort(data, middle + 1, right);
        merge(data, left, middle, right);
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

    mergeSort(data, 0, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
