package org.example.pattern.responsibility;

import org.springframework.core.Ordered;

public class SexyWordFilter implements WordFilter, Ordered {
    @Override
    public boolean filter(String content) {
        if("abc".endsWith(content)){
            System.err.println("filter by SexyWordFilter!");
            return true;
        }
        return false;
    }

    @Override
    public int getOrder() {
        return -10;
    }
}
