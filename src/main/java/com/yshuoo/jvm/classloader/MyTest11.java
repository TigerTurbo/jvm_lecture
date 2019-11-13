package com.yshuoo.jvm.classloader;

/**
 * @author yangshuo
 * @date 2019/11/13 19:38
 */
class Parent3 {
    static int a = 3;
    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething(){
        System.out.println("Parent3 doSomething");
    }
}

class Child3 extends Parent3 {

    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest11 {
    public static void main(String[] args){
        System.out.println(Child3.a); // 因为a是父类的，虽然通过子类访问，但是表示的是对父类的主动使用
        System.out.println("*************");
        Child3.doSomething();
    }
}
