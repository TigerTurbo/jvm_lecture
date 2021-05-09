package com.yshuoo.jvm.classloader;

/**
 * 扩展类加载器不能直接加载Class文件，需要打成jar包后才能加载
 */
public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {

        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }

}
