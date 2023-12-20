package com.ohgiraffers.semiproject.project.product.controller;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String str = "서울시강남구@대치동@1234-1";
        String[] strings = str.split("@");

        for (int i = 0; i < strings.length; i++) {
            System.out.println("strings = " + strings[i]);

        }

    }
}
