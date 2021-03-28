package sorting;


import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class argsAnalysis {
    public static Sorter parseArgs(String[] args) {
        SortingType sortingType = SortingType.NATURAL;
        DataType dataType = DataType.LINE;
        File inputFile = null;
        File outputFile = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                switch (args[i]) {
                    case "-sortingType":
                        if (i + 1 < args.length) {
                            switch (args[i + 1]) {
                                case "byCount":
                                    sortingType = SortingType.BY_COUNT;
                                    break;
                                case "natural":
                                    sortingType = SortingType.NATURAL;
                                    break;
                                default:
                                    throw new RuntimeException("Unknown sorting type: " + args[i + 1]);
                            }
                        } else {
                            throw new RuntimeException("No sorting type defined!");
                        }
                        i++;
                        break;
                    case "-dataType":
                        if (i + 1 < args.length) {
                            switch (args[i + 1]) {
                                case "long":
                                    dataType = DataType.LONG;
                                    break;
                                case "line":
                                    dataType = DataType.LINE;
                                    break;
                                case "word":
                                    dataType = DataType.WORD;
                                    break;
                                default:
                                    throw new RuntimeException("Unknown data type" + args[i]);
                            }
                        } else throw new RuntimeException("No data type defined!");
                        i++;
                        break;
                    case "-inputFile":
                        if (i + 1 < args.length) {
                            inputFile = new File("..\\Sorting Tool\\Sorting Tool\\task\\" + args[i + 1]);
                            if (!inputFile.exists()){
                                System.out.println("Input file doesn't exist!");
                            }
                        } else throw new RuntimeException("No input file defined");
                        i++;
                        break;
                    case "-outputFile":
                        if (i + 1 < args.length) {
                            try {
                                outputFile = new File("..\\Sorting Tool\\Sorting Tool\\task\\" + args[i + 1]);
                                if (outputFile.createNewFile()) {
                                    System.out.println("Create new output file!");
                                }
                            } catch (IOException e) {
                                System.out.println("IO Exception occurred!");
                            }
                        } else throw new RuntimeException("No output file defined");
                        i++;
                        break;
                    default:
                        throw new RuntimeException("Unexpected parameter: " + args[i]);
                }
            } else throw new RuntimeException("Unexpected parameter: " + args[i]);
        }
        if (inputFile == null && outputFile != null) {
            throw new RuntimeException("Don't have input file to solve");
        }
        return new Sorter(sortingType,dataType,inputFile,outputFile);
    }

}
