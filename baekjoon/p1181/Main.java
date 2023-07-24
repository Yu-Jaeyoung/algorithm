package src.baekjoon.p1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int wordCount = Integer.parseInt(bufferedReader.readLine());

        List<WordInfo> words = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        for (int i = 0; i < wordCount; i++) {
            String word = bufferedReader.readLine();
            if (uniqueWords.add(word)) {
                words.add(new WordInfo(word));
            }
        }

        words.sort(new Comparator<WordInfo>() {
            @Override
            public int compare(WordInfo wordInfo1, WordInfo wordInfo2) {
                int lengthCompare = Integer.compare(wordInfo1.length, wordInfo2.length);
                if (lengthCompare != 0) {
                    return lengthCompare;
                } else {
                    return wordInfo1.word.compareTo(wordInfo2.word);
                }
            }
        });

        for (WordInfo wordInfo : words) {
            System.out.println(wordInfo.word);
        }
    }

    static class WordInfo {
        String word;
        int length;

        public WordInfo(String word) {
            this.word = word;
            this.length = word.length();
        }
    }
}
