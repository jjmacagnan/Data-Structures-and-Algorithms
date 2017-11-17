package chapter_10.code;

import chapter_10.code.hash_tables.ChainHashMap;
import chapter_10.code.maps.Map;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        Map<String, Integer> freq = new ChainHashMap<>();

        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");

        while (doc.hasNext()) {
            String word = doc.next().toLowerCase();
            Integer count = freq.get(word);

            if (count == null)
                count = 0;

            freq.put(word, 1 + count);
        }

        int maxCount = 0;
        String maxWord = "no word";
        for (Entry<String, Integer> ent : freq.entrySet()) {
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.println("The most frequent word is '" + maxWord);
        System.out.println("' with " + maxCount + "occurrences.");
     }
}
