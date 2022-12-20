package org.example.time;

public class SortUtils {
    public static long getSortTime(Sort sort, int[] arr) {
        long timeSort = System.currentTimeMillis();
        for (int i = 0; i < 500; i++){
            sort.doSort(arr);
        }
        return System.currentTimeMillis() - timeSort;
    }
}
