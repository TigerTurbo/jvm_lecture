package com.yshuoo.jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class Analysis {

    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        while(true){
            list.add(new User());
        }
    }
}
