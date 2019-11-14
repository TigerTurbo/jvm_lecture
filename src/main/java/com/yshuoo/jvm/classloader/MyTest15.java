package com.yshuoo.jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        // 数组的类加载器与其元素的类加载器一致
        // 数组对象并不是由类加载器加载，而是在运行创建
        System.out.println(strings.getClass().getClassLoader());
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        // 如果是原始类型，则没有加载器，这里的null与上面的null表示含义不一样
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
