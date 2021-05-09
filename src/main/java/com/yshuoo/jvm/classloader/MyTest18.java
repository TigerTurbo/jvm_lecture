package com.yshuoo.jvm.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class MyTest18 {

    public static void main(String[] args) {
        /*URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
        URL[] urLs = extClassLoader.getURLs();
        for(URL url : urLs){
            System.out.println(url);
        }
        System.out.println("----------------------------");
        URLClassLoader bootstrapClassLoader = (URLClassLoader) extClassLoader.getParent();
        urLs = bootstrapClassLoader.getURLs();
        for(URL url : urLs){
            System.out.println(url);
        }
        System.out.println("----------------------------");*/
        // 查看加载器位置
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

}
