package com.yshuoo.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @Author yangshuo
 * @Date 2021/5/8 15:53
 */
public class MyTest19 {
    public static void main(String[] args) {

        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        System.out.println(MyTest19.class.getClassLoader());

    }
}
