package mergesort;

import java.util.Arrays;
import java.util.List;

public class MergeSortTask {
    public static void main(String[] args) {
        MergeSortLogic mergeSortLogic = new MergeSortLogic();
        MergeSortUtils mergeSortUtils = new MergeSortUtils();
        // Integer list
        List<Integer> intList = Arrays.asList(38, 27, 43, 3, 9, 82, 10);
        mergeSortLogic.mergeSort(intList);
        mergeSortUtils.printSortedlist(intList);
        System.out.println("\n-------------");

        // Double list
        List<Double> doubleList = Arrays.asList(38.5, 27.2, 43.0, 3.9, 9.1, 82.7, 10.5);
        mergeSortLogic.mergeSort(doubleList);
        mergeSortUtils.printSortedlist(doubleList);
        System.out.println("\n-------------");

        // Float list
        List<Float> floatList = Arrays.asList(38.5f, 27.2f, 43.0f, 3.9f, 9.1f, 82.7f, 10.5f);
        mergeSortLogic.mergeSort(floatList);
        mergeSortUtils.printSortedlist(floatList);


    }
}
