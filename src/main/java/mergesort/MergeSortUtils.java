package mergesort;

import java.util.List;

public class MergeSortUtils {

    // Method to print sorted list
    public void printSortedlist(List<? extends Number> list) {
        list.forEach(num -> System.out.print(num + " "));
    }
}
