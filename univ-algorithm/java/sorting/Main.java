import basic.SelectionSort;

public class Main {
    public static void main(String[] args) {

        Integer[] list = {8, 31, 48, 73, 3, 65, 20, 29, 11, 5};

        SelectionSort<Integer> selectionSort = new SelectionSort<>(list);
        selectionSort.sort();
        selectionSort.print();

        String[] stringList = {"가", "자", "다", "나", "라", "파"};
        SelectionSort<String> stringSelectionSort = new SelectionSort<>(stringList);
        stringSelectionSort.sort();
        stringSelectionSort.print();

        Double[] doubleList = {8.0, 31.0, 48.3, 48.2, 47.9, 20.1, 29.3, 11.7, 5.5};
        SelectionSort<Double> doubleSelectionSort = new SelectionSort<>(doubleList);
        doubleSelectionSort.sort();
        doubleSelectionSort.print();
    }
}
