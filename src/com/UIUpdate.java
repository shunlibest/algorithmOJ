package com;

import com.util.MD5Utils;

import java.io.File;
import java.io.IOException;

public class UIUpdate {
    private static String fileMd5 = "";

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("请输入配置文件的本地存放路径");
            return;
        }
        String path = args[0];
        if (!new File(path).exists()) {
            System.out.println("本地文件不存在:" + path);
            return;
        }
        if (new File(path).isDirectory()) {
            System.out.println("请不要输入目录:" + path);
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runCmd(path);
                }
            }
        }).start();
    }


    private static void runCmd(String path) {
        String md5 = MD5Utils.generateMD5(path);
        if (fileMd5.equals(md5)) {
            return;
        }
        fileMd5 = md5;
        System.out.println("update");
        try {
            Runtime.getRuntime().exec("adb push " + path + " /storage/emulated/0/Android/data/com.autonavi.gxdtaojin/temp/task/ui.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
