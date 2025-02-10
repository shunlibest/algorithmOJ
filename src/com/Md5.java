package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Md5 {

//    @Nullable
    public static String getFolderMD5( File folder) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 遍历文件夹中的所有文件并计算每个文件的MD5值
            if (!folder.isDirectory()) {
                return null;
            }
            File[] files = folder.listFiles();
            if (files == null) {
                return null;
            }
            Arrays.sort(files); // 对文件进行排序，保证每次结果一致性
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file);
                    byte[] dataBytes = new byte[1024];
                    int nread = 0;
                    while ((nread = fis.read(dataBytes)) != -1) {
                        md.update(dataBytes, 0, nread);
                    }
                    fis.close();
                } else if (file.isDirectory()) {
                    String folderMD5 = getFolderMD5(file);
                    if (folderMD5 != null) {
                        md.update(folderMD5.getBytes());
                    }
                }
            }
            // 计算最终的MD5值
            byte[] mdBytes = md.digest();

            // 将字节数组转成字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : mdBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File folder = new File("/Users/shunlihan/Downloads/soft_cleaned 2");
        String folderMD5 = getFolderMD5(folder);
        System.out.println("Folder MD5: " + folderMD5);

    }
}