package org.example.sorts;

import org.example.fileWorks.FileWork;
import org.example.time.Sort;

public class QuickSort implements Sort {
    private void sort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            sort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sort(source, leftBorder, rightMarker);
        }
    }

    @Override
    public void doSort(int[] arr) {
        FileWork work = new FileWork();
        arr = work.readInt("src/main/java/org/example/files/not_sorted.txt");
        sort(arr, 0, arr.length - 1);
    }
}
