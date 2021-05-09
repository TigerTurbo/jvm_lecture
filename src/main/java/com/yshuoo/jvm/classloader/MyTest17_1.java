package com.yshuoo.jvm.classloader;

/**
 * 重要说明
 * 子加载器所加载的类能够访问父加载器加载的类
 * 父加载器所加载的类无法访问到子记载器所加载的类
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception{
        // 将系统类加载器当做loader1的父加载器
        MyTest16 loader1 = new MyTest16("loader1");

        loader1.setPath("D:\\workspace\\");

        Class<?> clazz = loader1.loadClass("com.yshuoo.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();

    }

}
