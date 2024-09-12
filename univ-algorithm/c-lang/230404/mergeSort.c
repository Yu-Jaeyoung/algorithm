#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int count = 0;

/*
void merge(int data[], int left, int middle, int right) {

    int *tmp = (int *) malloc(sizeof(int) * (right - left + 1));

    int i, j, k, l;
    i = left;
    j = middle + 1;
    k = left;

    printf("merge 호출 횟수 : %d\n", ++count);
    printf("할당된 공간의 크기 : %d\n", right - left + 1);

    while (i <= middle && j <= right) {
        printf("비교 대상 값 1번 : %d 2번 : %d\n", data[i], data[j]);
        if (data[i] <= data[j]) {
            printf("1번 출력 / 접근하는 인덱스 번호 : %d\n", k);
            tmp[k++] = data[i++];
            printf("2번 출력 / 접근하는 인덱스 번호의 저장 후 값 : %d\n",tmp[k - 1]);
        } else {
            printf("3번 출력 / 접근하는 인덱스 번호 : %d\n", k);
            tmp[k++] = data[j++];
            printf("4번 출력 / 접근하는 인덱스 번호의 저장 후 값 : %d\n",tmp[k - 1]);
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
        printf("tmp[l]의 값 : %d\n", tmp[l]);
        data[l] = tmp[l];
    }
    printf("\n");
    free(tmp);
}
 */

void merge(int data[], int left, int middle, int right) {

    int *tmp = (int *) malloc(sizeof(int) * (right - left + 1));

    int i, j, k, l;
    i = left;
    j = middle + 1;
    k = 0;

    while (i <= middle && j <= right) {
        if (data[i] >= data[j]) {
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
        data[l] = tmp[l-left];
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
