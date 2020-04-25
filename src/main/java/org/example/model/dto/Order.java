package org.example.model.dto;

/**
 * @Author Adam_Guo
 * @Date 2020/4/17
 * @Version 1.0
 **/
public class Order {
    private int orderId;

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
