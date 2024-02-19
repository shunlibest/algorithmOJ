package com.vm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ClassFile {
    private static final List<Byte> res = new ArrayList<>();

    public static void main(String[] args) {
        appendU4(0XCAFE_BABEL);
        appendU4(52);

        //共计 26 个常量
        appendU2(26);
        //#1
        appendUtf8("com/TestCode");
        //#2
        appendUtf8("java/lang/Object");
        //#3
        appendUtf8("java/lang/System");
        //#4
        appendUtf8("java/io/PrintStream");
        //#5
        appendUtf8("Ljava/io/PrintStream;");
        //#6
        appendUtf8("out");
        //#7
        appendUtf8("<init>");
        //#8
        appendUtf8("()V");
        //#9
        appendUtf8("print");
        //#10
        appendUtf8("(Ljava/lang/String;)V");
        //#11
        appendUtf8("main");
        //#12
        appendUtf8("([Ljava/lang/String;)V");
        //#13
        appendUtf8("Hello Class File");
        //#14
        appendUtf8("Code");

        //#15
        appendClassInfo(1);
        //#16
        appendClassInfo(2);
        //#17
        appendClassInfo(3);
        //#18
        appendClassInfo(4);

        //#19: init ()void
        appendNameAndTypeInfo(7, 8);
        //#20: out Ljava/io/PrintStream;
        appendNameAndTypeInfo(6, 5);
        //#21: print (String)void
        appendNameAndTypeInfo(9, 10);

        //#22: Object.init()v
        appendMethodRefInfo(16, 19);
        //#23: PrintStream.print(String)v
        appendMethodRefInfo(18, 21);
        //#24: System.out:PrintStream;
        appendFieldRefInfo(17, 20);

        //#25: "Hello Class File"
        appendStringInfo(13);

        appendU2(0x21);
        //类名TestCode
        appendU2(15);
        //父类Object
        appendU2(16);
        //接口数量:0
        appendU2(0);

        //跳过字段信息
        appendU2(0);

        //方法个数:2
        appendU2(2);
        // public void init ()
        appendMethod(0x0001, 7, 8);
        appendU2(0);

        //public static void main (String)
        appendMethod(0x0009, 11, 12);
        appendU2(0);

        //属性信息
        appendU2(0);

        print();
        writeClassFile();
    }


    private static void appendU1(int u1) {
        appendU1(Short.parseShort(String.valueOf(u1)));
    }

    private static void appendU1(short u1) {
        if ((u1 & 0XFF00) != 0) {
            throw new RuntimeException("appendU1 error,value:" + u1);
        }
        res.add((byte) (u1 & 0xFF));
    }

    private static void appendU2(int u2) {
        if ((u2 >> 16) != 0) {
            throw new RuntimeException("appendU2 error,value:" + u2);
        }
        res.add((byte) (u2 >> 8 & 0xFF));
        res.add((byte) (u2 & 0x00FF));
    }

    private static void appendU4(long u4) {
        if ((u4 >> 32) != 0) {
            throw new RuntimeException("appendU4 error,value:" + u4);
        }
        res.add((byte) (u4 >> 24 & 0xFF));
        res.add((byte) (u4 >> 16 & 0xFF));
        res.add((byte) (u4 >> 8 & 0xFF));
        res.add((byte) (u4 >> 0 & 0xFF));
    }


    //添加一个字符串常量
    private static void appendUtf8(String string) {
        appendU1(1);
        appendU2(string.length());
        byte[] bytes = string.getBytes();
        for (byte b : bytes) {
            res.add(b);
        }
    }

    private static void appendClassInfo(int index) {
        appendU1(7);
        appendU2(index);
    }

    private static void appendNameAndTypeInfo(int nameIndex, int descriptorIndex) {
        appendU1(12);
        appendU2(nameIndex);
        appendU2(descriptorIndex);
    }

    private static void appendMethodRefInfo(int classIndex, int nameTypeIndex) {
        appendU1(10);
        appendU2(classIndex);
        appendU2(nameTypeIndex);
    }

    private static void appendFieldRefInfo(int classIndex, int nameTypeIndex) {
        appendU1(9);
        appendU2(classIndex);
        appendU2(nameTypeIndex);
    }

    private static void appendStringInfo(int stringIndex) {
        appendU1(8);
        appendU2(stringIndex);
    }

    private static void appendMethod(int accessFlags, int methodName, int descriptor) {
        appendU2(accessFlags);
        appendU2(methodName);
        appendU2(descriptor);
    }


    private static void print() {
        for (int i = 0; i < res.size(); i++) {
            Byte b = res.get(i);
            System.out.printf("%02X", b);
            if (i % 4 == 3) {
                System.out.print(" ");
            }
        }
    }

    private static void writeClassFile() {
        try {
            File file = new File("./TestCode.class");
            file.delete();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = new byte[res.size()];
            for (int i = 0; i < res.size(); i++) {
                bytes[i] = res.get(i);
            }
            fos.write(bytes);
            System.out.print("\n数据写入完毕");
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
