#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void heapify(int data[], int rootNum, int length) { // data[k]와 그 자식을 힙 성질을 만족 하도록 수선 진행

    /*
    //최소 힙
    int left = rootNum * 2 + 1;
    int right = rootNum * 2 + 2;
    int smaller, tmp;

    printf("rootNum : %d\n", rootNum);
    printf("left : %d\n", left);
    printf("right : %d\n", right);

    if (right <= length) {
        if (data[left] < data[right]) {
            smaller = left;
        } else {
            smaller = right;
        }
    } else if (left <= length) {
        smaller = left;
    } else {
        printf("passed\n\n");
        return;
    }
    printf("smaller : %d\n", smaller);

    if (data[smaller] < data[rootNum]) {
        tmp = data[rootNum];
        data[rootNum] = data[smaller];
        data[smaller] = tmp;
        printf("changed\n");
        printf("data[smaller] : %d\n", data[smaller]);
        printf("data[rootNum] : %d\n", data[rootNum]);
        heapify(data, smaller, length); // 바뀐 값으로 히프를 만족 하는지 판단 진행
    }
    */



    // 최대힙
    int left = rootNum * 2 + 1;
    int right = rootNum * 2 + 2;
    int bigger, tmp;

    if (right <= length) {
        if (data[left] > data[right]) {
            bigger = left;
        } else {
            bigger = right;
        }
    } else if (left <= length) {
        bigger = left;
    } else {
        return;
    }

    if (data[bigger] > data[rootNum]) {
        tmp = data[rootNum];
        data[rootNum] = data[bigger];
        data[bigger] = tmp;
        heapify(data, bigger, length); // 바뀐 값으로 히프를 만족 하는지 판단 진행
    }
}

void buildHeap(int data[], int length) {
    for (int i = (length - 1) / 2; i >= 0; i--) {
        heapify(data, i, length);
    }
}

void heapSort(int data[], int length) {

    int tmp;

    buildHeap(data, length); // 자료를 힙에 만족 하도록 변경 진행 (오름 차순이 목적 이므로, 최대 힙으로 정렬)

    printf("After buildHeap : ");
    for (int i = 0; i < length + 1; i++) {
        printf("%d ", data[i]);
    }
    printf("\n\n");

    printf("heapSort Start\n");


    for (int i = length; i >= 1; i--) {

        // root노드와 마지막 노드를 교환하는 작업
        tmp = data[i];
        data[i] = data[0]; // root와 마지막 노드 swap
        data[0] = tmp; // root에 마지막 노드 삽입
        // printf("swaped\n");

        // 마지막 노드를 제외하고 힙 수정 진행
        heapify(data, 0, i - 1);
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

    heapSort(data, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
