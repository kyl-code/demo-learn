package org.example.common;

import org.example.model.dto.Order;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
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
        Date date = new Date();
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

    /**
     * @return 两年前年度的第一个星期一
     */
    public static LocalDate getDayOfFirst(){
        LocalDate localDate = LocalDate.now().minusYears(2);
        LocalDate of = LocalDate.of(localDate.getYear(), 1, 1);
        return of.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
    }

    /**
     * 将date转换为localdate
     * @param date
     * @return
     */
    public static LocalDate convertDate(Date date){
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将localdate转换为date
     * @param localDate
     * @return
     */
    public static Date convertLocalDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
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

    /**
     * 获取当月的结束时间
     */
    private static LocalDateTime getEndtimeOfMonth(){
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    public static void main(String[] args) {
        LocalDateTime endtimeOfMonth = getEndtimeOfMonth();
        System.err.println(endtimeOfMonth);
    }

}
