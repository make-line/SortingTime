package org.example.fileWorks;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWork {
    public int[] readInt(String path) {
        StringBuilder str = new StringBuilder();

        try {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(str::append);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String[] strArray = str.toString().split(" ");
        int[] numArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numArray[i] = Integer.parseInt(strArray[i]);
        }
        return numArray;
    }

    public String[] readString(String path) {
        StringBuilder str = new StringBuilder();

        try {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(str::append);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return str.toString().split(" ");
    }

    public void write(int[] arr, String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            StringBuilder text = new StringBuilder();
            for (int j : arr) {
                text.append(j);
                text.append(" ");
            }
            writer.write(text.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void write(String s, String s1) {
        try (FileWriter writer = new FileWriter(s1, true)) {
            writer.write(s);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clean(String s1) {
        try (FileWriter writer = new FileWriter(s1, false)) {
            writer.write("");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}