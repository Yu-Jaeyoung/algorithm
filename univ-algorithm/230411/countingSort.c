#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void countingSort(int data[], int lastIndexNum) {

    int max = 0;

    for (int i = 0; i < lastIndexNum + 1; i++) { // 가장 큰 수를 찾음
        if (data[i] > max) {
            max = data[i];
        }
    }
    printf("data[] = ");
    for (int i = 0; i <= lastIndexNum; i++) {
        printf("%d ", data[i]);
    }

    printf("\n");
    printf("max data = %d\n", max);

    int *temp1 = (int *) malloc(sizeof(int) * (max + 1)); // max +1 까지 해야 0~max 까지 공간 할당
    int *temp2 = (int *) malloc(sizeof(int) * lastIndexNum + 1);

    for (int i = 0; i < max + 1; i++) { // 밑에서 연산자 사용을 위해서 temp1을 0으로 초기화
        temp1[i] = 0;
    }

    for (int i = 0; i <= lastIndexNum; i++) {
        temp2[i] = 0;
    }

    // 1st check
    printf("first  check / temp1 : ");
    for (int i = 0; i < max + 1; i++) {
        printf("%d ", temp1[i]);
    }
    printf("\n");

    for (int i = 0; i <= lastIndexNum; i++) { //data[]의 배열 값을 인덱스 번호로 가지는 temp1의 count 증가
        temp1[data[i]]++;
    }

    // 2nd check
    printf("second check / temp1 : ");
    for (int i = 0; i < max + 1; i++) {
        printf("%d ", temp1[i]);
    }
    printf("\n");

    for (int i = 1; i < max + 1; i++) { // 누적하는 과정 마지막 자리까지 누적 해야하므로 i < max 설정
        temp1[i] = temp1[i] + temp1[i - 1];
    }

    // third check
    printf("third  check / temp1 : ");
    for (int i = 0; i < max + 1; i++) {
        printf("%d ", temp1[i]);
    }
    printf("\n");


    // 여기까지 이해 완료


    for (int i = 0; i <= lastIndexNum; i++) {
        temp2[temp1[data[i]] - 1] = data[i];
        temp1[data[i]]--; // 중복되는 값이 없으면 지워도 무방
        printf("look temp1 : ");
        for (int j = 0; j < max + 1; j++) {
            printf("%d ", temp1[j]);
        }
        printf("\n");
    }


    // fourth check
    printf("fourth check / temp2 : ");
    for (int i = 0; i <= lastIndexNum; i++) {
        printf("%d ", temp2[i]);
    }
    printf("\n");


    for (int i = 0; i <= lastIndexNum; i++) {
        data[i] = temp2[i];
    }

    free(temp1);
    free(temp2);
}

int main() {

    int n;
    printf("랜덤 수의 개수를 입력하시오. : ");

    scanf("%d", &n);

    int *data = (int *) malloc(sizeof(int) * n);

    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        data[i] = rand() % 10;
    }

    printf("정렬 전 배열 : ");

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    printf("\n정렬 후 배열 : \n");

    countingSort(data, n - 1);

    for (int i = 0; i < n; i++) {
        printf("%d ", data[i]);
    }

    free(data);
}
