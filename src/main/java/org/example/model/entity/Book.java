package org.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = -7461935797407015221L;
    @Id	//主键id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
