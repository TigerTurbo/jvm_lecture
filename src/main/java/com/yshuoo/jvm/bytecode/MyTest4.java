package com.yshuoo.jvm.bytecode;

/**
 * @Author yangshuo
 * @Date 2021/5/10 15:37
 *
 * 栈帧（stack frame）
 *
 * 栈帧是一种帮助虚拟机执行方法调用与方法执行的数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息
 *
 */
public class MyTest4 {

    public static void  test(){
        System.out.println("test invoke static");
    }

    public static void main(String[] args) {
        test();
    }

}
