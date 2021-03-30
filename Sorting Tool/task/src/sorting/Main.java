package sorting;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type your argument (-sortingType/-dataType/-inputFile/-outputFile):");
        String[] arg = scanner.nextLine().split(" ");
        Sorter sorter = argsAnalysis.parseArgs(arg);
        sorter.excute();

    }
}
