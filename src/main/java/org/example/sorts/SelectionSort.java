package org.example.sorts;

import org.example.fileWorks.FileWork;
import org.example.time.Sort;

public class SelectionSort implements Sort {
    public void doSort(int[] arr) {
        FileWork work = new FileWork();
        arr = work.readInt("src/main/java/org/example/files/not_sorted.txt");
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            int min = arr[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            //меняем местами наименьший с sortArr[i]
            arr[i] = min;
        }
    }
}
