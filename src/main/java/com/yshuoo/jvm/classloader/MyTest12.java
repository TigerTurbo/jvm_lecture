package com.yshuoo.jvm.classloader;

/**
 * @author yangshuo
 * @date 2019/11/13 19:47
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类初始化
 */
class CL {
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {

    public static void main(String[] args) throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        // 不会导致类的初始化
        Class<?> clazz = loader.loadClass("com.yshuoo.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("******************");
        // 反射属于主动使用，会导致类的初始化
        clazz = Class.forName("com.yshuoo.jvm.classloader.CL");
        System.out.println(clazz);
    }

}
