package org.example.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorStatic {
    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorStatic(){
    }

    private static class IdGeneratorHold{
        private static IdGeneratorStatic instance = new IdGeneratorStatic();
    }

    public static IdGeneratorStatic getInstance(){
        return IdGeneratorHold.instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }
}
