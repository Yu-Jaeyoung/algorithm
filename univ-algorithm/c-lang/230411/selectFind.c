#include <stdio.h>
#include <stdlib.h>
#include <time.h>


// 가장 오른쪽 인덱스 값을 피봇으로 지정
int partition(int data[], int startIndexNum, int endIndexNum) {
    int pivot = data[endIndexNum];
    int tmp;
    int i = startIndexNum - 1;

    // 피벗보다 작으면 왼쪽으로, 피봇보다 크면 오른쪽으로 정렬
    for (int j = startIndexNum; j < endIndexNum; j++) {
        if (data[j] <= pivot) {
            tmp = data[++i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
    data[endIndexNum] = data[++i];
    data[i] = pivot;
    return i;
}

int selectFind(int data[], int startIndexNum, int endIndexNum, int searchOrderNum) {

    if (startIndexNum == endIndexNum) { // 시작 인덱스 번호와 마지막 인덱스 번호가 같은 상황 = 검색 하려는 값
        return data[startIndexNum];
    }

    int pivotIndexNum = partition(data, startIndexNum, endIndexNum);

    int pivotOrder = pivotIndexNum + 1;

    if (searchOrderNum > pivotOrder) {
        // 피봇 기준 오른쪽 그룹에서 탐색
        return selectFind(data, pivotIndexNum + 1, endIndexNum, searchOrderNum);
    } else if (searchOrderNum == pivotOrder) {
        // 찾으려는 값이 피봇이므로 반환
        return data[pivotIndexNum];
    } else {
        // 피봇 기준 왼쪽 그룹에서 탐색
        return selectFind(data, startIndexNum, pivotIndexNum - 1, searchOrderNum);
    }
}

/*
int selectFind(int data[], int startIndexNum, int endIndexNum, int searchOrderNum) {

    printf("startIndexNum : %d\n", startIndexNum);
    if (startIndexNum == endIndexNum) { // 시작 인덱스 번호와 마지막 인덱스 번호가 같은 상황 = 검색 하려는 값
        printf("시작 인덱스 번호와 마지막 인덱스 번호가 같은 상황 = 검색 하려는 값 실행\n");
        printf("data[startIndexNum] : %d\n", data[startIndexNum]);
        for (int i = 0; i < 5; i++) {
            printf("%d ", data[i]);
        }
        printf("\n");
        return data[startIndexNum];
    }

    int pivotIndexNum = partition(data, startIndexNum, endIndexNum);
    printf("pivotIndexNum : %d\n", pivotIndexNum);
    int pivotOrder = pivotIndexNum + 1;
    printf("pivotOrder : %d\n", pivotOrder);

    if (searchOrderNum > pivotOrder) {
        // 피봇 기준 오른쪽 그룹에서 탐색
        printf("피봇 기준 오른쪽 그룹에서 탐색 실행\n\n");
        return selectFind(data, pivotIndexNum + 1, endIndexNum, searchOrderNum);
    } else if (searchOrderNum == pivotOrder) {
        // 찾으려는 값이 피봇이므로 반환
        printf("찾으려는 값이 피봇이므로 실행\n\n");
        return data[pivotIndexNum];
    } else {
        // 피봇 기준 왼쪽 그룹에서 탐색
        printf("피봇 기준 왼쪽 그룹에서 탐색 실행\n\n");
        return selectFind(data, startIndexNum, pivotIndexNum - 1, searchOrderNum);
    }
}
*/

int main() {

    int count, searchOrderNum, order;

    printf("랜덤 수의 개수를 입력 : ");

    scanf("%d", &count);

    int *data = (int *) malloc(sizeof(int) * count);

    printf("찾으려는 순번 입력 : ");

    scanf("%d", &searchOrderNum);

    srand(time(NULL));

    for (int i = 0; i < count; i++) {
        data[i] = rand() % 100;
    }

    printf("검색하는 배열 : ");

    for (int i = 0; i < count; i++) {
        printf("%d ", data[i]);
    }
    printf("\n");

    order = selectFind(data, 0, count - 1, searchOrderNum);

    printf("\n배열의 %d번째 값은 %d입니다.\n", searchOrderNum, order);

    free(data);
}
