/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author GULE NARJIS
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PIPEandFILTER {
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Create a pipeline
        List<Function<List<Integer>, List<Integer>>> filters = new ArrayList<>();
        filters.add(PIPEandFILTER::filterEvenNumbers);
        filters.add(PIPEandFILTER::squareNumbers);
        filters.add(PIPEandFILTER::filterNumbersGreaterThanTen);
        filters.add(PIPEandFILTER::incrementNumbersByFive);  // New filter added here
        filters.add(PIPEandFILTER::filterOddNumbers);        // New filter added here
       
        // Process the input through the pipeline
        List<Integer> result = processPipeline(input, filters);

        // Output the result
        System.out.println(result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input, List<Function<List<Integer>, List<Integer>>> filters) {
        List<Integer> output = input;
        for (Function<List<Integer>, List<Integer>> filter : filters) {
            output = filter.apply(output);
        }
        return output;
    }

    // Filter to keep even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Filter to square the numbers
    private static List<Integer> squareNumbers(List<Integer> input) {
        return input.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Filter to keep numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
        return input.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
    }

    // **New Filter: Increment each number by 5**
    private static List<Integer> incrementNumbersByFive(List<Integer> input) {
        return input.stream()
                .map(n -> n + 5)
                .collect(Collectors.toList());
    }

    // **New Filter: Keep only even numbers (removes odd numbers)**
    private static List<Integer> filterOddNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}

    

