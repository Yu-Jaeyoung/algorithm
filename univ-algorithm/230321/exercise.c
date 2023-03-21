#include <stdio.h>

int main() {


    int coin[5] = {500, 100, 50, 10, 1};
    int money;
    int change_count[6] = {0};


    printf("1000원 미만의 거스름돈을 입력하시오 : ");
    scanf("%d", &money);

    printf("거스름돈은 ");

    for (int i = 0; i < 5; i++) {

        change_count[i] = money / coin[i];
        money = money % coin[i];
        printf("%d원 %d개", coin[i], change_count[i]);

        if (i < 4) {
            printf(", ");
        }
    }

    printf(" 입니다.");


    return 0;
}