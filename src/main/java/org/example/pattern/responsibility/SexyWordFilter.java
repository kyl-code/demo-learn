package org.example.pattern.responsibility;

public class SexyWordFilter implements WordFilter {
    @Override
    public boolean filter(String content) {
        if("abc".endsWith(content)){
            System.err.println("filter by SexyWordFilter!");
            return true;
        }
        return false;
    }
}
