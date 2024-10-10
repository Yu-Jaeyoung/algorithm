import advanced.HeapSort;
import advanced.MergeSort;
import advanced.QuickSort;
import advanced.ShellSort;
import basic.BubbleSort;
import basic.InsertionSort;
import basic.SelectionSort;
import common.SortList;
import java.util.Random;
import special.RadixSort;

public class PerformanceTest {

    public static final int SIZE = 500_000;

    public static void main(String[] args) {
        Integer[] selectionList = new Integer[SIZE];
        Integer[] bubbleList = new Integer[SIZE];
        Integer[] insertionList = new Integer[SIZE];
        Integer[] mergeList = new Integer[SIZE];
        Integer[] quickList = new Integer[SIZE];
        Integer[] heapList = new Integer[SIZE];
        Integer[] shellList = new Integer[SIZE];
        Integer[] radixList = new Integer[SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int value = random.nextInt(100_000);
            selectionList[i] = value;
            bubbleList[i] = value;
            insertionList[i] = value;
            mergeList[i] = value;
            quickList[i] = value;
            heapList[i] = value;
            shellList[i] = value;
            radixList[i] = value;
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

        SortList<Integer> insertionSort = new InsertionSort<>(insertionList);
        startTime = System.nanoTime();
        insertionSort.sort();
        endTime = System.nanoTime();
        System.out.println("삽입 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> mergeSort = new MergeSort<>(mergeList);
        startTime = System.nanoTime();
        mergeSort.sort();
        endTime = System.nanoTime();
        System.out.println("병합 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> quickSort = new QuickSort<>(quickList);
        startTime = System.nanoTime();
        quickSort.sort();
        endTime = System.nanoTime();
        System.out.println("퀵 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> heapSort = new HeapSort<>(heapList);
        startTime = System.nanoTime();
        heapSort.sort();
        endTime = System.nanoTime();
        System.out.println("힙 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> shellSort = new ShellSort<>(shellList);
        startTime = System.nanoTime();
        shellSort.sort();
        endTime = System.nanoTime();
        System.out.println("쉘 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");

        SortList<Integer> radixSort = new RadixSort(radixList);
        startTime = System.nanoTime();
        radixSort.sort();
        endTime = System.nanoTime();
        System.out.println("기수 정렬 시간: " + ((endTime - startTime) / 1000_000.0) + " ms");
    }
}
