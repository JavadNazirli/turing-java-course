package mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLogic {

    // Merge Sort algorithm (Generic)
    public <T extends Comparable<T>> void mergeSort(List<T> list) {
        int listSize = list.size();
        if (listSize <= 1) return; // base case

        // Finding the middle of the list
        int middle = listSize / 2;

        // Create the left and right halves of the list
        List<T> leftList = new ArrayList<>(list.subList(0, middle));
        List<T> rightList = new ArrayList<>(list.subList(middle, listSize));

        // Sort left and right halves recursively
        mergeSort(leftList);
        mergeSort(rightList);

        // Merge sorted lists
        merge(leftList, rightList, list);
    }

    // Method to merge two sorted lists (Generic)
    private <T extends Comparable<T>> void merge(List<T> leftList, List<T> rightList, List<T> list) {
        int i = 0; // index for merged list
        int l = 0; // index for left list
        int r = 0; // index for right list

        // Compare the elements from the left and right lists and place them in the main list
        while (l < leftList.size() && r < rightList.size()) {
            if (leftList.get(l).compareTo(rightList.get(r)) < 0) {
                list.set(i, leftList.get(l));
                l++;
            } else {
                list.set(i, rightList.get(r));
                r++;
            }
            i++;
        }

        // Add the remaining elements to the left list
        while (l < leftList.size()) {
            list.set(i, leftList.get(l));
            l++;
            i++;
        }

        // Add the remaining elements to the right list
        while (r < rightList.size()) {
            list.set(i, rightList.get(r));
            r++;
            i++;
        }
    }
}