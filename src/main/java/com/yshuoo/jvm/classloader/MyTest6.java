package com.yshuoo.jvm.classloader;

/**
 * @author yangshuo
 * @date 2019/11/6 19:46
 */
public class MyTest6 {

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }

}

class Singleton{
    public static int counter1;

    public static Singleton singleton = new Singleton();

    private Singleton(){
        counter1 ++;
        counter2 ++; // 主动使用，在准备阶段赋上初值
        System.out.println("counter1: " + counter1);
        System.out.println("counter2: " + counter2);
    }

    // 代码移到这里输出就变成了0，执行到这里时相当于又手工赋值0
    public static int counter2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }
}
