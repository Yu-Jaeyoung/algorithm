import basic.SelectionSort;

public class Main {
    public static void main(String[] args) {

        int[] list = {8, 31, 48, 73, 3, 65, 20, 29, 11, 5};

        SelectionSort selectionSort = new SelectionSort(list);
        selectionSort.sort();
        selectionSort.print();
    }
}
