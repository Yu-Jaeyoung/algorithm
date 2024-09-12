#include <stdio.h>
#include <stdlib.h>

int fibonacci_dp(int n) {
    int *dp = (int *) malloc(sizeof(int) * (n + 1));

    dp[0] = 0; // 피보나치 수열의 첫 번째 항
    dp[1] = 1; // 피보나치 수열의 두 번째 항

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    int result = dp[n];
    free(dp);

    return result;
}

int main() {
    int n = 10;

    printf("Result : %d", fibonacci_dp(n));

    return 0;
}
