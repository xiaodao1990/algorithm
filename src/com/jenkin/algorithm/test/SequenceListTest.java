package com.jenkin.algorithm.test;

import com.jenkin.algorithm.linear.SequenceList;

public class SequenceListTest {

    public static void main(String[] args) {
//        SequenceList<Object> s1 = new SequenceList<>(10);
//
//        s1.insert("大桥未久");
//        s1.insert("rio");
//        s1.insert("天海翼");
//
//        // 测试获取
//        s1.insert(1,  "波多野结衣");
//        String getResult = (String) s1.get(1);
//        System.out.println("获取索引为1处的结果： "+getResult);
//
//        // 测试indexOf
//        int index = s1.indexOf("rio");
//        System.out.println("rio的索引位置："+index);
//
//        // 测试删除
//        String removeResult = (String) s1.remove(0);
//        System.out.println("删除的元素是："+removeResult);
//
//        // 测试indexOf
//        index = s1.indexOf("rio");
//        System.out.println("rio的索引位置："+index);
//
//        for (Object obj : s1) {
//            System.out.println("当前线性表的元素："+ ((String) obj));
//        }
//
//        // 测试清空
//        s1.clear();
//        System.out.println("清空后的线性表中元素的个数为："+s1.length());
//
//        s1.insert(0, "姚明");
//        s1.insert(1, "科比");
//        for (Object obj : s1) {
//            System.out.println("当前线性表的元素："+ ((String) obj));
//        }

        SequenceList<Object> s1 = new SequenceList<>(5);
        s1.insert("大桥未久");
        s1.insert("rio");
        s1.insert("天海翼");
        s1.insert("波多野结衣");
        s1.insert("苍井空");
        System.out.println("扩容前线性表大小："+s1.capacity());
        s1.insert("麻生希");
        System.out.println("扩容前线性表大小："+s1.capacity());
        s1.remove(0);
        s1.remove(0);
        s1.remove(0);
        s1.remove(0);
        System.out.println("缩容后线性表大小："+s1.capacity());
    }
}
