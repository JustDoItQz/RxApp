package org.gisoper.com.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 100; i++){
            list.add(i);
        }
        System.out.println(list);
        int init = 20;// 每隔20条循环一次
        int total = list.size();
        int cycelTotal = total / init;
        int d = total % init;

        System.out.println("循环保存的次数：" + cycelTotal);// 循环多少次
        List<Object> list2 = new ArrayList<Object>();

        for (int i = 0; i < cycelTotal; i++){
            for (int j = 0; j < init; j++){
                if (list.get(j) == null){
                    break;
                }
                list2.add(list.get(j));
            }

            System.out.println("保存1000条数据到数据库....");
            System.out.println(list2);// 每次循环保存的数据输出
// 接下来写保存数据库方法
// .............
            list.removeAll(list2);// 移出已经保存过的数据
            list2.clear();// 移出当前保存的数据
        }
        if (d>0){
            for (int i = 0; i < d; i++){
                list2.add(list.get(i));
                System.out.println("-----------"+list.get(i));
            }
        }


    }
}
