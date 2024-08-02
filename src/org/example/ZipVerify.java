package org.example;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ZipVerify {

    public static void main(String[] args) {
        File file = new File("/Users/shunlihan/Downloads/627d157c5e5abb38e49323ccc06495dd_data.zip");

        try {
            boolean zipFile = isZipFile(file);
            System.out.println(zipFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //没有zip文件注释时候的目录结束符的偏移量
    private static final int RawEndOffset = 22;
    //0x06054b50占4个字节
    private static final int endOfDirLength = 4;
    //目录结束标识0x06054b50 的小端读取方式。
    private static final byte[] endOfDir = new byte[]{0x50, 0x4B, 0x05, 0x06};


    private static boolean isZipFile(File file) throws IOException {
        if (file.exists() && file.isFile()) {
            if (file.length() <= RawEndOffset + endOfDirLength) {
                return false;
            }
            long fileLength = file.length();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            //seek到结束标记所在的位置
            randomAccessFile.seek(fileLength - RawEndOffset);
            byte[] end = new byte[endOfDirLength];
            //读取4个字节
            randomAccessFile.read(end);
            //关掉文件
            randomAccessFile.close();
            return isEndOfDir(end);
        } else {
            return false;
        }
    }


    /**
     * 是否符合文件夹结束标记
     */
    private static boolean isEndOfDir(byte[] src) {
        if (src.length != endOfDirLength) {
            return false;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != endOfDir[i]) {
                return false;
            }
        }
        return true;
    }
}
