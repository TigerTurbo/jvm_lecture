package com.yshuoo.jvm.classloader;

import java.io.*;

/**
 * @author yangshuo
 * @date 2019/12/24 15:20
 */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName){
        super(); // 将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent); // 显式指定指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = this.loadClassData(className);
        return defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try{
            this.classLoaderName = this.classLoaderName.replace(".","/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();

        }catch (Exception x){
            x.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception{
        Class<?> clazz = classLoader.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);
    }
}
