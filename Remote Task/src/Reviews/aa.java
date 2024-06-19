package Reviews;

import java.util.*;

public class aa {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        System.out.println("Please enter the text:");

        String inputText = scanner.nextLine();



        String[] words = inputText.split("\\s+");



        List<String> wordList = new ArrayList<>();

        for (String word : words) {

            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!word.isEmpty()) {

                wordList.add(word);

            }

        }



        System.out.println("Enter the window size for co-occurrence analysis:");

        int windowSize = scanner.nextInt();



        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : wordList) {

            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);

        }



        Map<String, Map<String, Integer>> coOccurrence = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {

            String word = wordList.get(i);

            for (int j = Math.max(0, i - windowSize); j < Math.min(wordList.size(), i + windowSize + 1); j++) {

                if (i != j) {

                    String neighbor = wordList.get(j);

                    coOccurrence.putIfAbsent(word, new HashMap<>());

                    coOccurrence.get(word).put(neighbor, coOccurrence.get(word).getOrDefault(neighbor, 0) + 1);

                }

            }

        }



        System.out.println("\nWord Frequency:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());

        }



        System.out.println("\nCo-occurrence Frequency:");

        for (Map.Entry<String, Map<String, Integer>> entry : coOccurrence.entrySet()) {

            System.out.println(entry.getKey() + ":");

            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {

                System.out.println("    " + innerEntry.getKey() + ": " + innerEntry.getValue());

            }

        }



        scanner.close();

    }

}