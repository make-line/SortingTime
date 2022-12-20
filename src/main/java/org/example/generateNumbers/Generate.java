package org.example.generateNumbers;


import org.example.fileWorks.FileWork;

public class Generate {
    public void randomNum(String path, int n) {
        FileWork work = new FileWork();
        int[] notSortedArr = new int[n];
        for (int i = 0; i < notSortedArr.length; i++) {
            notSortedArr[i] = (int) (Math.random() * 5000);
        }
        work.write(notSortedArr, path);
    }
}
