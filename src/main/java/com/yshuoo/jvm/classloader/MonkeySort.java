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
        Random random = new Random();
        generate(random,0,10,0);
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
        Set<Integer> numberSet = new HashSet<>();
        System.out.println("第" + num + "次");
        for (int i = 0; i < 10; i++){
            int index = random.nextInt(10);
            while (numberSet.contains(index)){

            }
            numberSet.add(index);
            int number = array[index];
            result[i] = number;
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    private static void generate(Random random, int min, int max, int index){
        try{
            if (min == max){
                result[index] = min;
                return;
            }
            int s = random.nextInt(max) % (max - min + 1) + min;
            if (min <= s){
                generate(random,min,s,index++);
            }
            if (s+1 <= max){
                generate(random,s+1,max,index++);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
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
