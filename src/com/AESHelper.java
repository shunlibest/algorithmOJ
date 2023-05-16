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
        String decrypt = AESHelper.getInstance().decryptAndDecompress("1d278cad089637edef23f70ce76d71e552b2b399e36280ae6b31880f413eecc5abd551a5436bec099f4d4a0e8a507e7460733fe3dd6d2f49aed969ab6ac4ac6da9cd005cff7ddd38aff58308c4e2440f2eb9e1b3a85307211b0cdc20339a3a7822dbce935bd624926cc724b42a1b0274a6828a0cc013aaf82db332e73d1aaecc022ae1d7531a21af5b7d59007d05a81b43cac4b9a5851d00cb0a20bd5179c3d9455970e70ce45d7a094d098c1705b0f026492b0de6d1f51ca560302455c4d005aa7af2f472fd9acc8419d57ac6c94ee90a1bcfc918731763b050108cda63666fd50aa9c07e163b87914a82f334ea557047f8aee846edf4df31d0467667c4de9922ef7bded3580c19fbc4007664ddc31a40e4d027e931c19b8cb3e77d84e013a3da2baf1a2b6a78a4410a2d92c12b95d47f4329be37e2880050b0702c214cc237dc8928b82b0f66ca329d9d141665d80232be06f7bbff03e2b8f427a8a15f0e191dc7ddab6e67bdb098c73f6cc5a185d14b8b9f61bc20e2d61f884ac56c6c77e7a754b78be04ed4064836159166204d0fd806afe8bea2d5602964322a746c5b24a59717f32f301bc47c7fc9c062d635c6");
//        String encrypt = AESHelper.getInstance().compressAndEncrypt("{\"data\":{\"configDetail\":\"http://poi-collection.oss-cn-hangzhou.aliyuncs.com/taskform/daily/verify_poi_shop/20221222.xml?Expires=1983857904&OSSAccessKeyId=LTAI5tE5n5yE1Tf6zc8vvSip&Signature=Z6dhLDwOIfbzSoI7wP6rwIwzNPs%3D\",\"priceDetail\":{\"guid_map\":100,\"guid_map2\":100},\"configData\":{\"price\":{\"a\":\"100\",\"b\":\"200\"},\"position\":{\"pa\":\"家里\",\"pb\":\" 公司\"}},\"version\":\"20221222\"},\"errinfo\":\"\",\"errno\":0}\n");
//        String encrypt1 = AESHelper.getInstance().decryptAndDecompress(encrypt);
        System.out.println(decrypt);
//        System.out.println(encrypt);
//        System.out.println(encrypt1);
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