package com.yshuoo.jvm.classloader;

/**
 * @author yangshuo
 * @date 2019/11/5 20:30
 */
public class MyTest1 {

    public static void main(String[] args){
        System.out.println(MyChild1.str);
    }

}

class MyParent1{

    public static String str = "hello world";

    static{
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{

    public static String str2 = "Welcome";

    static {
        System.out.println("MyChild1 static block");
    }

}
