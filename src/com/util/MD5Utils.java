package com.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author hanshunli.hsl
 * @date 2022/12/12 14:45
 * @apiNote MD5的相关操作
 */
public class MD5Utils {

    /**
     * 生成文件的MD5码
     *
     * @param filePath 文件路径
     * @return 该文件的MD5码
     */

    public static String generateMD5(String filePath) {
        return generateMD5(new File(filePath));
    }

    /**
     * 生成文件的MD5码
     *
     * @param file 文件
     * @return 该文件的MD5码
     */
    public static String generateMD5(File file) {
        if (!file.isFile() || !file.exists()) {
            System.err.println("Error: " + file + " is not a valid file.");
            return null;
        }
        byte[] b = createChecksum(file);
        if (null == b) {
            System.err.println(("Error:create md5 string failure!"));
            return null;
        }
        StringBuilder result = new StringBuilder();

        for (byte value : b) {
            result.append(Integer.toString((value & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    /**
     * 辅助方法
     *
     * @param filename 文件名
     * @return return
     */
    private static byte[] createChecksum(File filename) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            byte[] buffer = new byte[1024];
            MessageDigest complete = MessageDigest.getInstance("MD5");
            int numRead = -1;

            while ((numRead = fis.read(buffer)) != -1) {
                complete.update(buffer, 0, numRead);
            }
            return complete.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
