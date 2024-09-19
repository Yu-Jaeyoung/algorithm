package basic;

import common.SortList;

public class InsertionSort<E extends Comparable<E>> extends SortList<E> {

    public InsertionSort(E[] list) {
        super(list);
    }

    @Override
    public void sort() {
        for (int i = 1; i <= list.length - 1; i++) {
            // i 번째 값을 제자리에 삽입하는 작업
            E newItem = list[i];
            int j = i - 1;

            for (; j >= 0 && newItem.compareTo(list[j]) < 0; j--) {
                list[j + 1] = list[j];
            }

            // j+1 위치가 newItem이 들어갈 위치
            list[j + 1] = newItem;
        }
    }
}
