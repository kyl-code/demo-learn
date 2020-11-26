package org.example.pattern.responsibility;


import org.springframework.core.Ordered;

public class OtherWordFilter implements WordFilter, Ordered {
    @Override
    public boolean filter(String content) {
        if("123".equals(content)){
            System.err.println("filter by OtherWordFilter!");
            return true;
        }
        return false;
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
