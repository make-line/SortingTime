package org.example.sorts;

import org.example.fileWorks.FileWork;
import org.example.time.Sort;

public class InsertionSort implements Sort {
    @Override
    public void doSort(int[] arr) {
        FileWork work = new FileWork();
        arr = work.readInt("src/main/java/org/example/files/not_sorted.txt");
        for (int left = 0; left < arr.length; left++) {
            // Вытаскиваем значение элемента
            int value = arr[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            arr[i + 1] = value;
        }
    }
}
