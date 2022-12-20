package org.example.sorts;

import org.example.time.Sort;
import org.example.fileWorks.FileWork;

public class BubbleSort implements Sort {
    public static void sort(int[] sort_arr, int len) {

        for (int i = 0; i < len - 1; ++i) {

            for (int j = 0; j < len - i - 1; ++j) {

                if (sort_arr[j + 1] < sort_arr[j]) {

                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j + 1];
                    sort_arr[j + 1] = swap;

                }
            }
        }
    }

    @Override
    public void doSort(int[] arr) {
        FileWork work = new FileWork();
        arr = work.readInt("src/main/java/org/example/files/not_sorted.txt");
        sort(arr, arr.length);
    }
}

