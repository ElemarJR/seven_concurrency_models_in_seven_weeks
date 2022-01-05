package com.elemarjr;

import java.util.HashMap;

public class WordCount {
    private static final HashMap<String, Integer> counts =
            new HashMap<>();

    public static void main(String[] args) throws Exception {
        var start = System.currentTimeMillis();
        var pages = new Pages(100000, "c:/data/enwiki-20211220-pages-articles-multistream.xml");
        for(Page page: pages) {
            Iterable<String> words = new Words(page.getText());
            for (String word: words)
                countWord(word);
        }
        var end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + "ms");
    }

    private static void countWord(String word) {
        var currentCount = counts.get(word);
        counts.put(word, currentCount == null ? 1 : currentCount + 1);
    }
}
