package com.yshuoo.jvm.classloader;

/**
 * @Author yangshuo
 * @Date 2021/4/13 16:32
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.s);
    }


}

class MyParent2{

    public static final String str = "hello world";

    public static final short s = 7;

    static {
        System.out.println("MyParent2 static block");
    }
}
