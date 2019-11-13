package com.yshuoo.jvm.classloader;

/**
 *
 * 类加载顺序
 * @author yangshuo
 * @date 2019/11/13 19:29
 */

class Parent2 {
    static int a = 3;
    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;
    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args){
        Parent2 parent2; // 不会导致任何输出
        System.out.println("***************");
        parent2 = new Parent2();
        System.out.println("***************");
        System.out.println(parent2.a); // 只初始化一次
        System.out.println("***************");
        System.out.println(Child2.b);
    }

}
