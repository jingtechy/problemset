package problemset;

import java.util.*;

public class FindTopNumbers {

    public static int[] findTopNumbers(int[][] arrays) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each number
        for (int[] array : arrays) {
            for (int number : array) {
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            }
        }

        // Sort numbers based on counts
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Get the top 6 numbers
        int[] result = new int[Math.min(6, sortedList.size())];
        for (int i = 0; i < result.length; i++) {
            result[i] = sortedList.get(i).getKey();
        }

        return result;
    }


    public static void main(String[] args) {
        // Example usage
        int[][] arrays = {
                {1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8},
                {4, 5, 6, 7, 8, 9},
                {5, 6, 7, 8, 9, 10},
                {6, 7, 8, 9, 10, 11},
                {7, 8, 9, 10, 11, 12},
                {8, 9, 10, 11, 12, 13},
                {9, 10, 11, 12, 13, 14},
                {10, 11, 12, 13, 14, 15},
                {11, 12, 13, 14, 15, 16},
                {12, 13, 14, 15, 16, 17},
                {13, 14, 15, 16, 17, 18},
                {14, 15, 16, 17, 18, 19}
        };

        int[] topNumbers = findTopNumbers(arrays);

        // Print the top numbers
        System.out.println("Top 6 Numbers:");
        for (int number : topNumbers) {
            System.out.print(number + " ");
        }
    }
}
