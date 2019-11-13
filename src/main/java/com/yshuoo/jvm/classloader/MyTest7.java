package com.yshuoo.jvm.classloader;

/**
 * 双亲委托机制
 */
public class MyTest7 {

    public static void main(String[] args){

        try {
            Class<?> clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getClassLoader());

            Class<?> clazz1 = Class.forName("com.yshuoo.jvm.classloader.C");
            System.out.println(clazz1.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class C {

}
