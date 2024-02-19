package com.vm;


import java.util.Date;

public class TestCodeMethod {
    public static void main(String[] args) {

    }

    public void invokeInterface() {
        Comparable<String> t1 = "test";
        String t2 = "test2";
        // INVOKESPECIAL java/lang/String.<init> (Ljava/lang/String;)V
        t1.compareTo(t2);
    }

    //
    public void invokeVirtual() {
        Object obj = new String("xxx");
        //  INVOKEVIRTUAL java/lang/Object.toString ()Ljava/lang/String;
        obj.toString();
    }

    public void invokeSpecial() {
        //情况1：类实例构造器方法：<init>()
        //  INVOKESPECIAL java/lang/Object.toString ()Ljava/lang/String;
        Date date = new Date();
        //情况2：父类的方法
        //  INVOKESPECIAL java/lang/Object.toString ()Ljava/lang/String;
        super.toString();
        //情况3：私有方法
        // INVOKESPECIAL com/TestCodeMethod.methodPrivate ()V
        methodPrivate();
    }

    private void methodPrivate() {

    }



}