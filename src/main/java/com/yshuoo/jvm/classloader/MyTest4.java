package com.yshuoo.jvm.classloader;

/**
 * @Author yangshuo
 * @Date 2021/4/15 15:11
 */
public class MyTest4 {

    public static void main(String[] args) {
        // MyParent4 myParent4 = new MyParent4();
        // MyParent4 myParent5 = new MyParent4();
        MyParent4[] myParent5 = new MyParent4[1];
        System.out.println(myParent5.getClass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }

}

class MyParent4{

    static{
        System.out.println("MyParent4 static block");
    }

}
