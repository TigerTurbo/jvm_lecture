package com.yshuoo.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author yangshuo
 * @Date 2021/5/10 19:13
 */
public class Client {

    public static void main(String[] args) {
        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),ds);
        subject.request();
        // class com.sun.proxy.$Proxy0
        System.out.println(subject.getClass());
        // class java.lang.reflect.Proxy
        System.out.println(subject.getClass().getSuperclass());

    }

}
