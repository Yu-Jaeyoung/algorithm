package basic;

public class SelectionSort {

    int[] list;

    public SelectionSort(int[] list) {
        this.list = list;
    }

    public void sort() {
        for (int last = list.length - 1; last > 0; last--) {
            int k = getLargest(last);
            swap(k, last);
        }
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    private void swap(int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    private int getLargest(int last) {
        int largest = 0;

        for (int i = 1; i <= last; i++) {
            if (list[i] > list[largest]) {
                largest = i;
            }
        }
        return largest;
    }
}
