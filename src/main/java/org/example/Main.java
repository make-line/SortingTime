package org.example;

import org.example.fileWorks.FileWork;
import org.example.generateNumbers.Generate;
import org.example.sorts.*;
import org.example.chart.Chart;
import org.example.time.Sort;
import org.example.time.SortUtils;

import javax.swing.*;
import java.util.*;


public class Main {
    static final int[] n = new int[]{50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

    static final long[][] sortTimeArray = new long[11][5];


    public static void main(String[] args) {
        FileWork work = new FileWork();
        Generate generate = new Generate();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1-Расчет
                    2-Запись результата в файл
                    3-Вывод результата из файла
                    4-Построить график по расчетам
                    5-Очистить файл с рассчетами
                    6-Выход""");
            int menuNum = scanner.nextInt();
            int[] initialArray;
            String[] result;
            switch (menuNum) {
                case 1 -> {
                    Sort[] sorts = new Sort[]{new BubbleSort(), new QuickSort(), new InsertionSort(), new SelectionSort(), new HeapSort()};
                    for (int i = 0; i < sorts.length; i++) {
                        generate.randomNum("src/main/java/org/example/files/not_sorted.txt", n[i]);
                        initialArray = work.readInt("src/main/java/org/example/files/not_sorted.txt");
                        SortUtils.getSortTime(sorts[i], initialArray);
                    }
                    for (int i = 0; i < 11; i++) {
                        generate.randomNum("src/main/java/org/example/files/not_sorted.txt", n[i]);
                        initialArray = work.readInt("src/main/java/org/example/files/not_sorted.txt");
                        for (int j = 0; j < sorts.length; j++) {
                            sortTimeArray[i][j] = SortUtils.getSortTime(sorts[j], initialArray);
                        }
                    }
                    JFrame frame = new JFrame("panel");
                    frame.setSize(1100, 700);
                    frame.add(Chart.createDemoPanel(sortTimeArray));
                    frame.setVisible(true);
                }
                case 2 -> {
                    if (sortTimeArray[0][0] == 0) {
                        System.out.println("Выполните рассчеты!");
                    } else {
                        String[] emptyFile = work.readString("src/main/java/org/example/files/result.txt");
                        if (Objects.equals(emptyFile[0], "")) {
                            work.write("n BS QS IS SS HS \n", "src/main/java/org/example/files/result.txt");
                            for (int i = 0; i < 11; i++) {
                                work.write(n[i] + " " + sortTimeArray[i][0] +
                                        " " + sortTimeArray[i][1] +
                                        " " + sortTimeArray[i][2] +
                                        " " + sortTimeArray[i][3] +
                                        " " + sortTimeArray[i][4] + " \n", "src/main/java/org/example/files/result.txt");
                            }
                            work.clean("src/main/java/org/example/files/bin.txt");
                            for (int i = 0; i < 11; i++) {
                                work.write(sortTimeArray[i][0] +
                                        " " + sortTimeArray[i][1] +
                                        " " + sortTimeArray[i][2] +
                                        " " + sortTimeArray[i][3] +
                                        " " + sortTimeArray[i][4] + " \n", "src/main/java/org/example/files/bin.txt");
                            }
                        } else {
                            System.out.println("Очистите файл!");
                        }
                    }
                }
                case 3 -> {
                    result = work.readString("src/main/java/org/example/files/result.txt");
                    if (Objects.equals(result[0], "")) {
                        System.out.println("Файл пуст!");
                    } else {
                        System.out.println("__________________________________________");
                        System.out.print("|   " + result[0] + "  ");
                        for (int i = 1; i < 6; i++) {
                            System.out.print("|  " + result[i] + "  ");
                            if (i % 6 == 5) {
                                System.out.print("|\n");
                                System.out.println("__________________________________________");
                            }
                        }
                        for (int i = 6; i < result.length; i++) {
                            if (Integer.parseInt(result[i]) / 10 == 0) {
                                System.out.print("|   " + result[i] + "  ");
                            } else if (Integer.parseInt(result[i]) / 100 == 0) {
                                System.out.print("|  " + result[i] + "  ");
                            } else if (Integer.parseInt(result[i]) / 1000 == 0) {
                                System.out.print("| " + result[i] + "  ");
                            } else if (Integer.parseInt(result[i]) / 10000 == 0) {
                                System.out.print("| " + result[i] + " ");
                            }
                            if (i % 6 == 5) {
                                System.out.print("|\n");
                                System.out.println("__________________________________________");
                            }
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ignored) {
                        }
                        System.out.print("\n");
                    }
                }
                case 4 -> {
                    String[] calc = work.readString("src/main/java/org/example/files/bin.txt");
                    int j = 0, i = 0, n = 0;
                    long[][] calcResults = new long[11][5];
                    while (n < 55) {
                        while (j < 5) {
                            calcResults[i][j] = Long.parseLong(calc[n]);
                            j++;
                            n++;
                        }
                        j = 0;
                        i++;
                    }
                    JFrame frame = new JFrame("panel");
                    frame.setSize(1100, 700);
                    frame.add(Chart.createDemoPanel(calcResults));
                    frame.setVisible(true);
                }
                case 5 -> {
                    work.clean("src/main/java/org/example/files/result.txt");
                    work.clean("src/main/java/org/example/files/bin.txt");
                    System.out.println("Файл с рассчетами очищен");
                }
                default -> System.exit(1);
            }
        }
    }

}
