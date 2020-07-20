package org.example.pattern.responsibility;


public class OtherWordFilter implements WordFilter {
    @Override
    public boolean filter(String content) {
        if("123".equals(content)){
            System.err.println("filter by OtherWordFilter!");
            return true;
        }
        return false;
    }
}
