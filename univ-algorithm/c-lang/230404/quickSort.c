#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int partition(int data[], int left, int right) {
    int pivot = data[right];
    int i = left - 1;
    int tmp;

    for (int j = left; j <= right - 1; j++) {
        if (data[j] <= pivot) {
            tmp = data[++i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }

    data[right] = data[i + 1];
    data[i + 1] = pivot;

    return i + 1;
}

void quickSort(int data[], int left, int right) {
    if (left < right) {
        int q = partition(data, left, right);
        quickSort(data, left, q - 1);
        quickSort(data, q + 1, right);
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

    quickSort(data, 0, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
