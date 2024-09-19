package advanced;

import common.SortList;

public class MergeSort<E extends Comparable<E>> extends SortList<E> {

    public MergeSort(E[] list) {
        super(list);
    }

    private void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private void merge(int p, int q, int r) {
        // p, q   q+1, r 을 병합
        // 병합한 임시 결과를 저장할 tmp 배열을 생성
        E[] tmp = (E[]) new Comparable[r - p + 1];
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (list[i].compareTo(list[j]) <= 0) {
                tmp[t++] = list[i++];
            } else {
                tmp[t++] = list[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = list[i++];
        }

        while (j <= r) {
            tmp[t++] = list[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            list[i++] = tmp[t++];
        }
    }

    @Override
    public void sort() {
        mergeSort(0, list.length - 1);
    }
}
