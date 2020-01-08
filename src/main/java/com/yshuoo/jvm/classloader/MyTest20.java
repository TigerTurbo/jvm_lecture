package com.yshuoo.jvm.classloader;

import java.lang.reflect.Method;

public class MyTest20 {

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz1 = loader1.loadClass("com.yshuoo.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.yshuoo.jvm.classloader.MyPerson");
        System.out.println(clazz1 == clazz2);

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1,o2);


    }

}
