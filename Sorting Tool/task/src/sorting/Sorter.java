package sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Sorter {
    Scanner scanner = new Scanner(System.in);
    private List<String> lines;
    private SortingType sortingType;
    private DataType dataType;
    private File input;
    private File output;
    private Map<String,Integer> sortedLines;
    public Sorter(SortingType sortingType, DataType dataType, File input, File output){
        lines = new ArrayList<>();
        this.sortingType = sortingType;
        this.dataType = dataType;
        this.input = input;
        this.output = output;
    }
    private void read() {
        if (input == null) {
            switch (dataType) {
                case LINE:
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                    break;
                case WORD:
                    while (scanner.hasNext()) {
                        lines.add(scanner.next());
                    }
                    break;
            }
        } else {
            switch (dataType) {
                case LINE:
                    try (Scanner scanner = new Scanner(input)) {
                        while (scanner.hasNextLine()) {
                            lines.add(scanner.nextLine());
                        }
                    } catch (IOException e) {
                        System.out.println("No file found:" + e.getMessage());
                    }
                    break;
                case WORD:
                    try (Scanner scanner = new Scanner(input)) {
                        while (scanner.hasNext()) {
                            lines.add(scanner.next());
                        }
                    } catch (IOException e) {
                        System.out.println("No file found:" + e.getMessage());
                    }
                    break;
            }
        }
    }
    private void sort() {
        switch (sortingType){
            case NATURAL:
                Collections.sort(lines);
                break;
            case BY_COUNT:
                Map<String,Integer> map = new TreeMap<>();
                for (String line: lines) {
                    map.put(line,map.getOrDefault(line,0) + 1);
                }
                sortedLines = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new));
        }

    }
    public String toString() {
        String type = (dataType.equals(DataType.WORD))?"words: ":"lines: ";
        StringBuilder output = new StringBuilder("Total " + type + lines.size() + "\n");
        switch (sortingType) {
            case NATURAL:
                output.append("Sorted data:\n");
                for (int i = 0; i < lines.size(); i++) {
                    if (i == lines.size() - 1) output.append(lines.get(i));
                    else output.append(lines.get(i) + "\n");
                }
                break;
            case BY_COUNT:
                for (String key: sortedLines.keySet()) {
                    double percent = (double)sortedLines.get(key) / lines.size() * 100;
                    output.append(key + String.format(": %d time(s), %.0f%%\n",sortedLines.get(key), percent));
                }
                break;
        }
        return output.toString();
    }
    public void excute(){
        this.read();
        this.sort();
        String result = this.toString();
        if (output == null) System.out.println(result);
        else {
            try (PrintWriter printWriter = new PrintWriter(output)) {
                printWriter.println(result);
                System.out.println("Successful sort data to " + output.getName());
            } catch (IOException e) {
                System.out.println("Unable to write to file" + e.getMessage());
            }
        }
    }
}
