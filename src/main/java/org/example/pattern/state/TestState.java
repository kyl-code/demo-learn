package org.example.pattern.state;

public class TestState {
    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainCape();
        marioStateMachine.obtainFire();
        marioStateMachine.obtainMushRoom();
        marioStateMachine.meetBoss();

        System.err.println(String.format("State:%d and Score :%d", marioStateMachine.getState().getValue(), marioStateMachine.getScore()));

    }
}
