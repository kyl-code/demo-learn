package org.example.pattern.responsibility;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class WordFilterChain {
    private List<WordFilter> filters = Lists.newArrayList();

    public void addFilter(WordFilter wordFilter){
        this.filters.add(wordFilter);
    }

    public boolean filter(String content){
        boolean result = false;
        for(WordFilter filter : filters){
            result = filter.filter(content);
            if(result){
                break;
            }
        }
        return result;
    }
}
