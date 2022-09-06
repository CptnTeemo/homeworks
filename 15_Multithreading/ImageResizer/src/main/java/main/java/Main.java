package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "./data/src";
        String dstFolder = "./data/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int processorCores = Runtime.getRuntime().availableProcessors();

        List<File[]> filesList = new ArrayList<>();
        int partFilesSize = 0;

        if (files != null) {
            partFilesSize = files.length / processorCores;
            filesList = splitArray(files, partFilesSize);
        }

        for (int i = 0; i < processorCores; i++) {
            System.out.println("Thread " + i + " have been started");
            new ImageResizer(filesList.get(i), newWidth, dstFolder, start).start();
        }

    }

    public static List<File[]> splitArray(File[] files, int partArraySize) {
        List<File[]> filesList = new ArrayList<>();
        if (files == null || files.length == 0) {
            return filesList;
        }

        int from = 0;
        int to = 0;
        int partArrays = 0;
        while (partArrays < files.length) {
            to = from + Math.min(partArraySize, files.length - to);
            File[] partFilesArray = Arrays.copyOfRange(files, from, to);
            filesList.add(partFilesArray);
            partArrays += partFilesArray.length;
            from = to;
        }
        return filesList;
    }
}
