package com.yshuoo.jvm.classloader;

/**
 * 类加载顺序
 * @author yangshuo
 * @date 2019/11/13 19:22
 */

class Parent {
    static int a = 3;
    static {
        // 2
        System.out.println("Parent static block");
    }
}

class Child extends Parent {
    static int b = 4;
    static {
        // 3
        System.out.println("Child static block");
    }
}

public class MyTest9 {

    static {
        // 1
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args){
        System.out.println(Child.b);
    }

}
