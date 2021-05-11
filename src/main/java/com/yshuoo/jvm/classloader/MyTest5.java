package com.yshuoo.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成初始化
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会导致父接口初始化
 * 因为接口中都是常量，单static就不行
 * @author yangshuo
 * @date 2019/11/6 19:31
 */
public class MyTest5 {

    public static void main(String[] args){

        System.out.println(MyChild5.b);

        System.out.println(MyParent5_1.thread);
    }

}

interface MyParent5 {
    public static final int a = 5;
    // public static final int a = new Random().nextInt(2); 如果删掉MyParent5的class文件会报错

    public static Thread thread = new Thread(){
        {
            // 运行之后不会输出，说明接口没有初始化
            System.out.println("MyParent5 invoked");
        }
    };

}

class MyChild5 implements MyParent5 {
    public static int b = 6;
    // public static final int b = new Random().nextInt(2); 如果删掉MyParent5的class文件会报错
}

interface MyGrandpa5{
    public static Thread thread = new Thread(){
        {
            // 运行之后不会输出，说明接口没有初始化
            System.out.println("MyGrandpa5 invoked");
        }
    };
}

interface MyChild6 extends MyGrandpa5{
    public static Thread thread = new Thread(){
        {
            // 运行之后不会输出，说明接口没有初始化
            System.out.println("MyChild6 invoked");
        }
    };
}

interface MyGrandpa5_1{
    public static Thread thread = new Thread(){
        {
            // 运行之后不会输出，说明接口没有初始化
            System.out.println("MyGrandpa5_1 invoked");
        }
    };
}

interface MyParent5_1 extends MyGrandpa5_1{
    public static Thread thread = new Thread(){
        {
            // 运行之后不会输出，说明接口没有初始化
            System.out.println("MyParent5_1 invoked");
        }
    };
}

