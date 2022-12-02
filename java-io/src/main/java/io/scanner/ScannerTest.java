package io.scanner;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Worker[] wokers = new Worker[5];
        for (int i = 0; i < 5; i++) {
            wokers[i] = new Worker(i * 100 + i * 10 + i + "", i * 10 + i, i % 2 == 1);
        }
        File file = new File("/Users/hongchaoliang/Documents/git/owner/java-Basic/java-io/src/main/java/io/scanner/data.txt");
        try (PrintWriter printWriter = new PrintWriter(file, StandardCharsets.UTF_8.name())) {
            writeData(printWriter, wokers);
        } catch (IOException e) {
            System.out.println(e);
        }

        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name())) {
            System.out.println(scanner.nextInt());
            // scanner.nextInt() 不会换行 nextLine 换行一次
            System.out.println(scanner.nextLine());
            for (int i = 0; i < 5; i++) {
                System.out.println(readData(scanner));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void writeData(PrintWriter printWriter, Worker[] workers) {
        printWriter.println(workers.length);
        for (Worker worker : workers) {
            printWriter.println(worker.toString());
        }
    }

    private static Worker readData(Scanner scanner) {
        String[] line = scanner.nextLine().split("\\|");
        return new Worker(line[0], Integer.parseInt(line[1]), Boolean.parseBoolean(line[2]));
    }

}
