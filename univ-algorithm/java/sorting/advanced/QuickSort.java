package advanced;

import common.SortList;

public class QuickSort<E extends Comparable<E>> extends SortList<E> {

    public QuickSort(E[] list) {
        super(list);
    }

    private void quickSort(int p, int r) {
        if (p < r) {
            int k = (int) (Math.random() * (r - p + 1)) + p;    // 기준원소(pivot)을 랜덤으로 선택
            swap(k, r);
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }

    }

    private int partition(int p, int r) {

        E pivot = list[r];
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (list[j].compareTo(pivot) < 0) {
                swap(++i, j);
            }
        }

        swap(i + 1, r);

        return i + 1;
    }

    @Override
    public void sort() {
        quickSort(0, list.length - 1);
    }

}
