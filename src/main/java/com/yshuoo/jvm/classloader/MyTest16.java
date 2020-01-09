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
        super(); // 将系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent); // 显式指定指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent){
        super(parent);
    }


    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoked " + className);
        System.out.println("class loader name " + this.classLoaderName);

        byte[] data = this.loadClassData(className);
        return defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        name = name.replace(".","\\");

        try{

            is = new FileInputStream(new File(this.path + name + this.fileExtension));
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

    /*public static void test(ClassLoader classLoader) throws Exception{
        Class<?> clazz = classLoader.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }*/

    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        // 这里还是系统类加载器
        /*loader1.setPath("/d/workspace/jvm_lecture/target/classes");*/
        // 这里指定了路径，并且删除了系统里的myTest1,父加载器加载不了，所以只能由我们定义的加载器加载
        loader1.setPath("D:\\workspace\\");
        // 重新构建之后，myTest1会出现在系统路径下，再执行时，系统类加载器可以找到系统下有myTest1，所以不会走到指定路径
        Class<?> clazz = loader1.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();
        Thread.sleep(20000);


        loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\workspace\\");
        clazz = loader1.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        /**//*MyTest16 loader2 = new MyTest16("loader2");*//*
        *//**
         * 这种初始化方式，在MyTest1已经被删除的情况下，由于loader1是父加载器，在上面已经被加载过了
         * 所以这里不会再去重新加载，直接返回loader1加载的结果
         *//*
        MyTest16 loader2 = new MyTest16(loader1,"loader2");
        loader2.setPath("D:\\workspace\\");

        // 这里不会二次加载，同一个类只会加载一次
        // 如果删掉已经编译的MyTest1，会加载两次
        Class<?> clazz2 = loader2.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        MyTest16 loader3 = new MyTest16("loader3");
        loader3.setPath("D:\\workspace\\");
        Class<?> clazz3 = loader3.loadClass("com.yshuoo.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);*/


    }
}
