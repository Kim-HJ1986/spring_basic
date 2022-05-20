package com.spring_baisic.week1.domain;

import java.util.ArrayList;
import java.util.List;

public class Prac {
    // main함수가 static이기 때문에 main 함수에서 호출하려면 static을 넣어줘야 한다!
    public static void printHi(){
        System.out.println("HI HI HI HI HI~");
    }
    public static void main(String[] args) {
        // float은 뒤에 f 를 붙여준다.
        float f = 3.6f;
        // Long은 뒤에 L을 붙여준다.
        Long L = 10000000000L;
        long s = 10000000000l;
        System.out.println(L + s);

        List<String> stringList = new ArrayList<>();
        String s1 = "string1";
        String s2 = "string2";
        stringList.add(s1);
        stringList.add(s2);
        System.out.println(stringList);
        System.out.println(stringList.get(0));
        stringList.remove(0);
        System.out.println(stringList.get(0));
    }
}
