package basic;

import common.SortList;

public class SelectionSort<E extends Comparable<E>> extends SortList<E> {

    public SelectionSort(E[] list) {
        super(list);
    }

    @Override
    public void sort() {
        for (int last = list.length - 1; last > 0; last--) {
            int k = getLargest(last);
            swap(k, last);
        }
    }

}
