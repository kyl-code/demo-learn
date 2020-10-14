package org.example.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author adam.guo
 * @date:2020/10/14
 */
public class CalculateSortUtil {
    private static List<List<?>> allList = new ArrayList<>();
    public static <T>void getAll(List<T> list,List<T> list2,int n){
        for (T object : list2) {
            List<T> ll = new ArrayList<>();
            ll.add(object);
            List<T> ll2 = new ArrayList<>(list2);
            ll2.remove(object);
            ll.addAll(list);
            getAll(ll,ll2,n);
            if(ll.size() == n){
                allList.add(ll);
            }
        }
    }

    public static void main(String[] args) {
        List<String> data = Arrays.asList("12","25","18");
        getAll(new ArrayList<String>(),data,data.size());
        for (List<?> list: allList) {
            System.out.println(list);
        }
    }
}
