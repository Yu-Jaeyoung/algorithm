#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int data[], int length) { // 데이터 개수를 받은 length
    int tmp; // swap 과정에서 값을 저장할 공간
    int swapCount = -1;
    for (int i = length - 1; i > 0; i--) {

        if (!swapCount) {
            break;
        }
        swapCount = 0;
        for (int j = 0; j < i; j++) {
            if (data[j] > data[j + 1]) {
                tmp = data[j];
                data[j] = data[j + 1];
                data[j + 1] = tmp;
                swapCount++;
            }
        }
    }
}

int main() {

    int n;
    printf("랜덤 수의 개수를 입력하시오. : ");

    scanf("%d",&n);

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

    bubbleSort(data, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
