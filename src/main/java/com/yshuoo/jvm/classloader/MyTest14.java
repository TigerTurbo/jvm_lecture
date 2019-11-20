package com.yshuoo.jvm.classloader;


import java.net.URL;
import java.util.Enumeration;

/**
 * @author yangshuo
 * @date 2019/11/13 20:11
 */
public class MyTest14 {

    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/yshuoo/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("**************");

        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());
        clazz = String.class;
        System.out.println(clazz.getClassLoader());
    }

}
