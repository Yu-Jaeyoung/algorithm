import advanced.MergeSort;
import basic.BubbleSort;
import basic.InsertionSort;
import basic.SelectionSort;
import common.SortList;

public class Main {
    public static void main(String[] args) {

        Integer[] list = {8, 31, 48, 73, 3, 65, 20, 29, 11, 5};

        // SortList<Integer> sort = new SelectionSort<>(list);
        // SortList<Integer> sort = new BubbleSort<>(list);
        // SortList<Integer> sort = new InsertionSort<>(list);
        SortList<Integer> sort = new MergeSort<>(list);
        sort.sort();
        sort.print();

        String[] stringList = {"가", "자", "다", "나", "라", "파"};
        // SortList<String> stringSort = new SelectionSort<>(stringList);
        // SortList<String> stringSort = new BubbleSort<>(stringList);
        // SortList<String> stringSort = new InsertionSort<>(stringList);
        SortList<String> stringSort = new MergeSort<>(stringList);
        stringSort.sort();
        stringSort.print();

        Double[] doubleList = {8.0, 31.0, 48.3, 48.2, 47.9, 20.1, 29.3, 11.7, 5.5};
        // SortList<Double> doubleSort = new SelectionSort<>(doubleList);
        // SortList<Double> doubleSort = new BubbleSort<>(doubleList);
        // SortList<Double> doubleSort = new InsertionSort<>(doubleList);
        SortList<Double> doubleSort = new MergeSort<>(doubleList);
        doubleSort.sort();
        doubleSort.print();
    }
}
