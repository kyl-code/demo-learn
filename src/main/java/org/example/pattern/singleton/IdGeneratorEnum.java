package org.example.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGeneratorEnum {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);
    public Long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        Long id = IdGeneratorEnum.INSTANCE.getId();
        System.out.println(id);
    }
}
