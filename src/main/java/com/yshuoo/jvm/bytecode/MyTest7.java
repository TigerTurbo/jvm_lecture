package com.yshuoo.jvm.bytecode;

import java.util.Date;

/**
 * @Author yangshuo
 * @Date 2021/5/10 16:56
 */
public class MyTest7 {

    public static void main(String[] args) {
        Anmial anmial = new Anmial();
        Anmial dog = new Dog();

        anmial.test("hello");
        dog.test(new Date());
    }

}

class Anmial{

    public void test(String str){
        System.out.println("Animal str");
    }

    public void test(Date date){
        System.out.println("Anmial date");
    }

}

class Dog extends Anmial{
    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }
}
