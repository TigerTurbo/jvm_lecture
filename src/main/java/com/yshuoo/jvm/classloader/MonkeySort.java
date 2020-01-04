package com.yshuoo.jvm.classloader;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author yangshuo
 * @date 2020/1/3 14:57
 */
public class MonkeySort {

    private static int [] array = new int[10];
    private static int [] result = new int[10];

    static{
        generate();
    }

    /**
     * 检查数组是否有序
     * @return
     */
    private static boolean checkOrder (int array[]){
        for (int i = 1; i < 10; i++){
            if (array[i] <= array[i-1]){
                return false;
            }
        }
        return true;
    }

    private static void sort(int num, Random random){
        Set<Integer> numberSet = new HashSet<Integer>();
        System.out.println("第" + num + "次");
        for (int i = 0; i < 10; i++){
            int index = random.nextInt(10);
            while (numberSet.contains(index)){
                index = random.nextInt(10);
            }
            numberSet.add(index);
            int number = array[index];
            result[i] = number;
            System.out.print(" " + result[i]);
        }
        System.out.println();
    }

    private static void generate(){
        array[0]=8;
        array[1]=5;
        array[2]=3;
        array[3]=6;
        array[4]=4;
        array[5]=9;
        array[6]=7;
        array[7]=10;
        array[8]=1;
        array[9]=2;
    }




    public static void main(String[] args){
        Random random = new Random();

        int num = 0;
        long startTime = System.currentTimeMillis();

        while(true){
            sort(num++,random);
            boolean isOrder = checkOrder(result);
            if (isOrder){
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序完成，耗时：" + (endTime-startTime)/1000 + " S");

    }


}
