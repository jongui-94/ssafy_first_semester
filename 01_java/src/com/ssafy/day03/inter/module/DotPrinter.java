package com.ssafy.day03.inter.module;

public class DotPrinter implements Printer{

    @Override
    public void print(String fileName) {
        System.out.println(fileName + "파일을 Dot Printer로 프린트 한다.");
    }

}
