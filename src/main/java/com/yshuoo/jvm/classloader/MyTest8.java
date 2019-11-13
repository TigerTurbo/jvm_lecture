package com.yshuoo.jvm.classloader;

/**
 * Final理解
 * @author yangshuo
 * @date 2019/11/13 19:09
 */
public class MyTest8 {

    public static void main(String[] args){
        System.out.println(FinalTest.x);
    }
}

class FinalTest {

    /**
     * 下面两种会打印
     * public static int x = 3; 没有进入常量池
     * public static final int x = new Random().nextInt(3); 运行期才会确定
     */
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }

}