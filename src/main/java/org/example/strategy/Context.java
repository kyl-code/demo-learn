package org.example.strategy;

/**
 * @Author Adam_Guo
 * @Date 2020/4/20
 * @Version 1.0
 **/
public class Context {
    private Person person;

    public Context(Person person){
        this.person = person;
    }

    public void eat(){
        person.eat();
    }
}
