package org.example.pattern.responsibility;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestResponsibility {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WordFilterChain.class);
        context.register(OtherWordFilter.class);
        context.register(SexyWordFilter.class);
        context.refresh();
        WordFilterChain wordFilterChain = context.getBean(WordFilterChain.class);
        OtherWordFilter otherWordFilter = context.getBean(OtherWordFilter.class);
        SexyWordFilter sexyWordFilter = context.getBean(SexyWordFilter.class);
        wordFilterChain.addFilter(otherWordFilter);
        wordFilterChain.addFilter(sexyWordFilter);
        boolean abc = wordFilterChain.filter("ABC");
        System.err.println(abc);
/*        WordFilterChain wordFilterChain = new WordFilterChain();
        wordFilterChain.addFilter(new SexyWordFilter());
        wordFilterChain.addFilter(new OtherWordFilter());
        boolean result = wordFilterChain.filter("abc");
        System.err.println(result);*/
    }
}
