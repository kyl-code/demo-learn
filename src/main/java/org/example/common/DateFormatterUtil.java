package org.example.common;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.example.model.dto.Order;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Adam_Guo
 * @Date 2020/4/17
 * @Version 1.0
 **/
public class DateFormatterUtil {

    private static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getNowDateStr() {
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(dtf1);
        return format;
    }

    public static String getNowDataTimeStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dtf2);
        return format;
    }

    public static LocalDateTime getDataTime() {
        String str = "2020-04-05 10:20:30";
        LocalDateTime parse = LocalDateTime.parse(str, dtf2);
        return parse;
    }

    public static LocalDateTime getNextMonth() {
        LocalDateTime now = LocalDateTime.now();
        // LocalDateTime localDateTime = now.plusMonths(1L);
        LocalDateTime localDateTime = now.with(TemporalAdjusters.firstDayOfYear()).plusDays(255);
        return localDateTime;
    }

    public static LocalDateTime getRandomDataTime() {
        LocalDateTime localDateTime = LocalDateTime.now().with(temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100), ChronoUnit.DAYS));
        return localDateTime;
    }

    public static void main(String[] args) {
        List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println(collect);

        int elementCount = 1000000;
        int loopCount = 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("listSearch");
        Object list = listSearch(elementCount, loopCount);
        System.out.println(ObjectSizeCalculator.getObjectSize(list));
        stopWatch.stop();
        stopWatch.start("mapSearch");
        Object map = mapSearch(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(stopWatch.prettyPrint());
    }


    private static Object listSearch(int elementCount, int loopCount) {
        List<Order> list = IntStream.rangeClosed(1, elementCount).mapToObj(i -> new Order(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Order result = list.stream().filter(order -> order.getOrderId() == search).findFirst().orElse(null);
        });
        return list;
    }

    private static Object mapSearch(int elementCount, int loopCount) {
        Map<Integer, Order> map = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toMap(Function.identity(), i -> new Order(i)));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Order result = map.get(search);
        });
        return map;
    }
}