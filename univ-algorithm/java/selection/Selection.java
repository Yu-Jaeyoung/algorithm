import java.util.Arrays;

public class Selection {
    private void swap(Integer[] list, int i, int j) {
        Integer tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    private int partition(Integer[] list, int p, int r) {
        return partition(list, p, r, list[r]);
    }

    private int partition(Integer[] list, int p, int r, Integer x) {
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (list[j] < x) {
                swap(list, ++i, j);
            }
        }
        swap(list, i + 1, r);
        return i + 1;
    }

    private Integer select(Integer[] list, int p, int r, int i) {
        if (p == r) {
            return list[p];
        }

        int q = partition(list, p, r);

        System.out.println(q + " --> " + Arrays.toString(list));

        int k = q - p + 1;

        if (i < k) {
            return select(list, p, q - 1, i);
        } else if (i > k) {
            return select(list, q + 1, r, i - k);
        } else {
            return list[q];
        }
    }

    public static void main(String[] args) {
        // Integer[] intList = {8, 31, 48, 73, 3, 65, 20, 29, 11, 15, 90, 17, 25, 38, 40, 55, 77, 99, 7, 64};
        Integer[] intList = {31, 9, 48, 73, 11, 3, 20, 29, 65, 15};

        Selection selection = new Selection();
        Integer value = selection.select(intList, 0, intList.length - 1, 2);

        System.out.println("2번째로 작은 값은 " + value + "입니다.");

    }

}
