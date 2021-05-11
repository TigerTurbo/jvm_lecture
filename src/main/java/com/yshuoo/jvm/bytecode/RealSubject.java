package com.yshuoo.jvm.bytecode;

/**
 * @Author yangshuo
 * @Date 2021/5/10 19:10
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
