package com.jenkin.algorithm.test;

import com.jenkin.algorithm.linear.TwoWayLinkList;

public class TwoWayLinkListTest {

    public static void main(String[] args) {
        TwoWayLinkList<String> twoWayLinkList = new TwoWayLinkList<>();
        twoWayLinkList.insert(0, "天海翼");
        twoWayLinkList.insert(1, "大桥未久");
        twoWayLinkList.insert(2, "麻生希");
        twoWayLinkList.insert(3, "波多野结衣");
        for (String str : twoWayLinkList) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = twoWayLinkList.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = twoWayLinkList.remove(3);
        System.out.println(remove);
        System.out.println(twoWayLinkList.length());
        System.out.println("--------------------");
        System.out.println(twoWayLinkList.getFirst());
        System.out.println(twoWayLinkList.getLast());
    }
}
