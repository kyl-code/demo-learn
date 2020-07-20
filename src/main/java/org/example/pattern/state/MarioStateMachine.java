package org.example.pattern.state;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarioStateMachine {
    private State state;
    private int score;

    public MarioStateMachine() {
        this.state = State.SMALL;
        this.score = 0;
    }

    public void obtainMushRoom() {
        this.state = State.SUPER;
        this.score = score + 30;
    }

    public void obtainFire() {
        this.state = State.FIRE;
        this.score = score + 10;
    }

    public void obtainCape() {
        this.state = State.CAPE;
        this.score = score + 20;
    }

    public void meetBoss() {
        this.state = State.SMALL;
        this.score = score - 20;
    }

    public State getState() {
        return this.state;
    }

    public int getScore() {
        return this.score;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        iterator1.next();
        iterator1.remove();
        iterator2.next(); // 运行结果？
    }
}
