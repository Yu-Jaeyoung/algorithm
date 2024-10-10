package special;

import common.SortList;

public class RadixSort extends SortList<Integer> {
    public RadixSort(Integer[] list) {
        super(list);
    }

    private void sortRadix(int exp) {
        int[] count = new int[10];
        int[] result = new int[list.length];

        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        for (int j = 0; j < list.length; j++) {
            int index = (list[j] / exp) % 10;
            count[index]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int j = list.length - 1; j >= 0; j--) {
            int index = (list[j] / exp) % 10;
            result[count[index] - 1] = list[j];
            count[index]--;
        }

        for (int j = 0; j < list.length; j++) {
            list[j] = result[j];
        }
    }


    @Override
    public void sort() {
        int maxIndex = getLargest(list.length - 1);
        int max = list[maxIndex];

        for (int exp = 1; max / exp > 0; exp *= 10) {
            sortRadix(exp);
        }
    }
}
