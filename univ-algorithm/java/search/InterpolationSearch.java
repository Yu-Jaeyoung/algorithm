public class InterpolationSearch {
    public static void main(String[] args) {
        int[] S = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int n = S.length;
        int x = 32;

        int result = interpsrch(n, S, x);
        if (result == -1) {
            System.out.println("없음");
        } else {
            System.out.println(result + " 위치에 값이 있음");
        }
    }

    private static int interpsrch(int n, int[] S, int x) {
        int low = 0;
        int high = n - 1;
        int i = -1;
        if (S[low] <= x && x <= S[high]) {
            System.out.println("low = " + low + ", high = " + high);
            while (low <= high && i == -1) {
                int denominator = S[high] - S[low];
                int mid;

                if (denominator == 0) {
                    mid = low;
                } else { // x가 있을법한 위치로 mid를 결정
                    mid = low + ((x - S[low]) * (high - low)) / denominator;
                }

                if (x == S[mid]) {
                    i = mid;
                } else if (x < S[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return i;
    }
}
