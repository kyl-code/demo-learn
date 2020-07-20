package org.example.pattern.responsibility;

public class TestResponsibility {

    public static void main(String[] args) {
        WordFilterChain wordFilterChain = new WordFilterChain();
        wordFilterChain.addFilter(new SexyWordFilter());
        wordFilterChain.addFilter(new OtherWordFilter());
        boolean result = wordFilterChain.filter("abc");
        System.err.println(result);
    }
}
