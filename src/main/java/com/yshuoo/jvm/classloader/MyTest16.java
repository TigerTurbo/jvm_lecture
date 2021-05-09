package com.yshuoo.jvm.classloader;

import java.io.*;

/**
 * @author yangshuo
 * @date 2019/12/24 15:20
 */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName){
        super(); // 将系统类加载器当做该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent); // 显式指定父类加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest16{" + "classLoaderName='" + classLoaderName + '\'' + '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);
        System.out.println("class  loader name: " + this.classLoaderName);
        byte[] bytes = this.loadClassDate(className);
        return this.defineClass(className,bytes,0,bytes.length);
    }

    private byte[] loadClassDate(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".","/");

        try {

            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        // 在本地建立指定目录，然后删掉idea编译的MyTest1，可以发现findClass执行了
        loader1.setPath("D:\\workspace\\");
        // loader1.setPath("/d/workspace/jvm_lecture/target/classes/");
        Class<?> clazz = loader1.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println("************");

        /*MyTest16 loader2 = new MyTest16(loader1,"loader2");
        loader2.setPath("D:\\workspace\\");
        Class<?> clazz2 = loader2.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        System.out.println("************");

        MyTest16 loader3 = new MyTest16(loader2,"loader3");
        loader3.setPath("D:\\workspace\\");
        Class<?> clazz3 = loader3.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz3.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);*/

        loader1 = null;
        clazz = null;
        object = null;
        System.gc();

        Thread.sleep(2000);

        loader1 = new MyTest16("loader1");
        // 在本地建立指定目录，然后删掉idea编译的MyTest1，可以发现findClass执行了
        loader1.setPath("D:\\workspace\\");
        // loader1.setPath("/d/workspace/jvm_lecture/target/classes/");
        clazz = loader1.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
    }
}
