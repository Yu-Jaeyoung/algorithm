import basic.BubbleSort;
import basic.SelectionSort;
import common.SortList;
import java.util.Random;

public class PerformanceTest {

    public static final int SIZE = 100_000;

    public static void main(String[] args) {
        Integer[] selectionList = new Integer[SIZE];
        Integer[] bubbleList = new Integer[SIZE];
        Integer[] insertionList = new Integer[SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int value = random.nextInt(100_000);
            selectionList[i] = value;
            bubbleList[i] = value;
            insertionList[i] = value;
        }

        SortList<Integer> selectionSort = new SelectionSort<>(selectionList);
        long startTime = System.nanoTime();
        selectionSort.sort();
        long endTime = System.nanoTime();
        System.out.println("선택 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> bubbleSort = new BubbleSort<>(bubbleList);
        startTime = System.nanoTime();
        bubbleSort.sort();
        endTime = System.nanoTime();
        System.out.println("버블 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> insertionSort = new BubbleSort<>(insertionList);
        startTime = System.nanoTime();
        insertionSort.sort();
        endTime = System.nanoTime();
        System.out.println("삽입 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");
    }
}
