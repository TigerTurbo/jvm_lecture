package com.yshuoo.jvm.classloader;

/**
 * 类加载器结构
 * @author yangshuo
 * @date 2019/11/13 19:58
 */
public class MyTest13 {

    public static void main(String[] args){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }

}
