#include <stdio.h>
#include <stdlib.h>

#ifndef max
#define max(a, b)  (((a) > (b)) ? (a) : (b))
#endif

int LCS(int **Table, char *X, char *Y, int LEN_X, int LEN_Y) {

    for (int i = 1; i < LEN_X; i++) {
        for (int j = 1; j < LEN_Y; j++) {
            if (X[i - 1] == Y[j - 1]) {
                Table[i][j] = Table[i - 1][j - 1] + 1;
            } else {
                Table[i][j] = max(Table[i - 1][j], Table[i][j - 1]);
            }
        }
    }

    return Table[LEN_X - 1][LEN_Y - 1];
}

void LCS_PrintTable(int **Table, char *X, char *Y, int LEN_X, int LEN_Y) {
    int i;
    int j;

    printf("%3s", "");

    for (i = 0; i < LEN_Y; i++) {
        printf("%c", Y[i]);
    }
    printf("\n");

    for (i = 0; i < LEN_X; i++) {
        if (i == 0) {
            printf("%2s", "");
        } else {
            printf("%-2c", X[i - 1]);
        }

        for (j = 0; j < LEN_Y; j++) {
            printf("%d", Table[i][j]);
        }
        printf("\n");
    }
}

int main() {
    char X[] = "GOOD MORNING.";
    char Y[] = "GUTEN MORGEN.";

    int LEN_X = sizeof(X);
    int LEN_Y = sizeof(Y);

    int **Table = (int **) malloc(sizeof(int *) * LEN_X);

    for (int i = 0; i < LEN_X; i++) {
        Table[i] = (int *) malloc(sizeof(int) * LEN_Y);
    }

    for (int i = 0; i < LEN_X; i++) {
        for (int j = 0; j < LEN_Y; j++) {
            Table[i][j] = 0;
        }
    }

    int result = LCS(Table, X, Y, LEN_X, LEN_Y);

    LCS_PrintTable(Table, X, Y, LEN_X, LEN_Y);

    printf("LCS = %d\n", result);

    free(Table[0]);
    free(Table);
}
