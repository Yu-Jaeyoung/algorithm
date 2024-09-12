package basic;

import common.SortList;

public class BubbleSort<E extends Comparable<E>> extends SortList<E> {

    public BubbleSort(E[] list) {
        super(list);
    }

    @Override
    public void sort() {
        for (int last = list.length - 1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    swap(i, i + 1);
                }
            }
        }
    }
}
