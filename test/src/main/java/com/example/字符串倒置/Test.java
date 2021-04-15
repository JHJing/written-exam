package com.example.字符串倒置;

/**
 * @program: test
 * @description:
 * @author: JJH
 * @create: 2021-04-15 12:43
 **/
public class Test {

    /**
     * 字符串倒置
     *
     * @param s
     * @return
     */
    public static String reverse(String s) {
        if (s.length() <= 0) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }


    public static void main(String[] args) {
        System.out.println(reverse("我是一串测试字符"));
    }



}
