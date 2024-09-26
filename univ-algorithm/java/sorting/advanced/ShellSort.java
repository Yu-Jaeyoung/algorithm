package advanced;

import common.SortList;

public class ShellSort<E extends Comparable<E>> extends SortList<E> {

    public ShellSort(E[] list) {
        super(list);
    }

    @Override
    public void sort() {
        int[] steps = {7, 3, 1};

        for (int step : steps) {
            for (int k = 0; k <= step - 1; k++) {
                stepInsertionSort(k, step);
            }
        }
    }

    private void stepInsertionSort(int k, int step) {
        for (int i = k + step; i <= list.length - 1; i += step) {
            // i 번째 값을 제자리에 삽입하는 작업
            E newItem = list[i];
            int j = i - step;

            for (; j >= 0 && newItem.compareTo(list[j]) < 0; j -= step) {
                list[j + step] = list[j];
            }

            // j+1 위치가 newItem이 들어갈 위치
            list[j + step] = newItem;
        }
    }
}
