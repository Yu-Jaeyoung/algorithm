package special;

import common.SortList;

public class CountingSort extends SortList<Integer> {
    public CountingSort(Integer[] list) {
        super(list);
    }

    @Override
    public void sort() {
        final int MAX_VALUE = list[getLargest(list.length - 1)];

        int[] count = new int[MAX_VALUE + 1];
        int[] result = new int[list.length];

        for (int i = 0; i <= MAX_VALUE; i++) {
            count[i] = 0;
        }

        for (int j = 0; j < list.length; j++) {
            count[list[j]]++;
        }

        for (int i = 1; i <= MAX_VALUE; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int j = list.length - 1; j >= 0; j--) {
            result[count[list[j]]-1] = list[j];
            count[list[j]]--;
        }

        for (int j = 0; j < list.length; j++) {
            list[j] = result[j];
        }
    }


}
