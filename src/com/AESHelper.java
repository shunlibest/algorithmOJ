package com;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.test.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * 类说明: AES加密和zip压缩工具类
 *
 * @author tuanwang.ltw
 */
public class AESHelper {
    private static AESHelper mAesHelper = new AESHelper();
    private static Logger logger = new Logger();
    private String algo;
    /**
     * 图片解密算法，不补充
     */
    private String pictureAlgo;
    private byte[] keyValue;

    private AESHelper() {
        super();
        algo = "AES/ECB/PKCS5Padding";
        pictureAlgo = "AES/ECB/NOPADDING";

        keyValue = "newwayy key_).(!".getBytes();
    }

    public static void main(String[] args) throws Exception {
        String decrypt = AESHelper.getInstance().decryptAndDecompress("b343031a6c25f74a3219864d99a4e264a23c65888543b45b6d27e2bf05016875e0796733628866bc5c29b9020bcc9e14276210fbd71f8184fdbbb2a3cf5728c311d7515e11218f544934cc55da440299d83a837522a7297226672d0cc75d50272dd89ae808cc3da95d7b1b33e17cfc5ffc74819e54770fd6a855c875fcdc11774191cdd7dee08cad58801381e937dee5c51980baa40f45cb616e34866879d9a136c52e19bb10c80befb735f250e107f579a2f4b6b493678008644ad7ea2f3efb1833c7dba1ab108310253fd6d652c0dac196fa49947862b4c83ca4350f65157210d99b7c3f31ae2bb7808ec1a474732d295c09cdd9a42f367dde1da9869221a53387ac6c3e81f4976b8b24f8b711a831ea6c76b03db7ef0980fe0603213c639094104951b84920c48684574611c2becae630f4b8eeafe33df30f8f007069bbab76edab0b1372b7207e97688bb897afb96a1800cda63adadeeb523113328fea30");
//        byte[] encrypt = AESHelper.getInstance().encrypt("hello".getBytes());
        System.out.println(decrypt);
    }

    private static synchronized void syncInit() {
        if (mAesHelper == null) {
            mAesHelper = new AESHelper();
        }
    }

    public static AESHelper getInstance() {
        if (mAesHelper == null) {
            syncInit();
        }

        return mAesHelper;
    }

    /**
     * 压缩&加密接口
     * @param data
     * @return
     */
    public String compressAndEncrypt(String data) {
        String ret = null;
        byte[] passBytes = null;
        if (data != null) {
            try {
                passBytes = compress(data.getBytes());
                ret = toHexString(encrypt(passBytes));
            } catch (Exception e) {
                logger.error("compressAndEncrypt error,data:{}", data, e);
            }
        }
        return ret;
    }

    /**
     * 解密&解压统一接口
     * @param content
     * @return
     */
    public String decryptAndDecompress(String content) {
        String ret = null;
        byte[] passBytes = null;
        try {
            passBytes = decrypt(toByteArray(content));
            ret = new String(decompress2(passBytes), "UTF-8");
        } catch (Exception e) {
            logger.error("decryptAndDecompress error,data:{}", content, e);
        }

        return ret;
    }


    /**
     * 压缩 不加密接口
     * @param data
     * @return
     */
    public String encryptNotCompress(String data) {
        String ret = null;
        byte[] passBytes = null;
        if (data != null) {
            try {
                passBytes = data.getBytes();
                ret = toHexString(encrypt(passBytes));
            } catch (Exception e) {
                logger.error("encryptNotCompress error,data:{}", data, e);
            }
        }
        return ret;
    }

    /**
     * 解密 不解压统一接口
     * @param content
     * @return
     */
    public String decryptNoDecompress(String content) {
        String ret = null;
        byte[] passBytes = null;
        try {
            passBytes = decrypt(toByteArray(content));
            ret = new String(passBytes, "UTF-8");
        } catch (Exception e) {
            logger.error("decryptNoDecompress error,data:{}", content, e);
        }

        return ret;
    }


    /**
     * AES加密接口
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] encrypt(byte[] data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE, key);

        return c.doFinal(data);
    }

    /**
     * AES解密接口
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] decrypt(byte[] data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.DECRYPT_MODE, key);

        return c.doFinal(data);
    }

    /**
     * AES解密接口
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] decryptPicture(byte[] data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(pictureAlgo);
        c.init(Cipher.DECRYPT_MODE, key);

        return c.doFinal(data);
    }

    /**
     * zlib压缩
     *
     * @param data
     *            待压缩数据
     * @return byte[] 压缩后的数据
     */
    public byte[] compress(byte[] data) {
        byte[] output = new byte[0];

        Deflater compresser = new Deflater();

        compresser.reset();
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            logger.error("compress error", e);
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                logger.error("compress error", e);
            }
        }
        compresser.end();
        return output;
    }

    /**
     * zlib解压缩算法1
     *
     * @param zipByte
     *            待压缩的数据
     * @return byte[] 解压缩后的数据
     */
    public byte[] decompress(byte[] zipByte) {
        ByteArrayOutputStream aos = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        // inflater.setInput(zipByte);
        int num = zipByte.length - (int) zipByte[zipByte.length - 1];
        inflater.setInput(zipByte, 0, num);
        byte[] buff = new byte[1024];
        int byteNum = 0;
        while (!inflater.finished()) {
            try {
                byteNum = inflater.inflate(buff);
                aos.write(buff, 0, byteNum);
            } catch (DataFormatException e) {
                logger.error("decompress error", e);
            }
        }

        return aos.toByteArray();
    }

    /**
     * zlib解压缩算法2
     *
     * @param data
     *            待压缩的数据
     * @return byte[] 解压缩后的数据
     */
    public byte[] decompress2(byte[] data) {
        byte[] output = new byte[0];

        Inflater decompresser = new Inflater();
        decompresser.reset();

        // 去掉填充字段
        // int num = data.length - (int) data[data.length - 1];
        // decompresser.setInput(data, 0, num);

        decompresser.setInput(data);

        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            logger.error("decompress error", e);
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                logger.error("decompress error", e);
            }
        }

        decompresser.end();
        return output;
    }

    // 将16进制字符串转化为字节数组
    public byte[] toByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray
     *            需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1) {
            throw new IllegalArgumentException("this byteArray must not be null or empty");
        }

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            //// 0~F前面不零
            if ((byteArray[i] & 0xff) < 0x10) {
                hexString.append("0");
            }
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, "AES");
        return key;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String aLGO) {
        algo = aLGO;
    }

    public byte[] getKeyValue() {
        return keyValue;
    }

    public String getKeyValues() {
        if (keyValue != null) {
            return keyValue.toString();
        } else {
            return null;
        }
    }

    public void setKeyValue(byte[] keyValue) {
        this.keyValue = keyValue;
    }

    public void setKeyValue(String keyValue) {
        if (keyValue != null) {
            this.keyValue = keyValue.getBytes();
        }
    }
}