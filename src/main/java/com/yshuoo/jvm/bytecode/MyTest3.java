package com.yshuoo.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @Author yangshuo
 * @Date 2021/5/10 14:44
 */
public class MyTest3 {
    public void test(){
        try{
            InputStream inputStream = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);

            serverSocket.accept();
        }catch (FileNotFoundException f){

        }catch (IOException io){

        }catch (Exception e){

        }finally {
            System.out.println("finally");
        }
    }
}
