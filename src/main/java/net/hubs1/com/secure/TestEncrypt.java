package net.hubs1.com.secure;

import net.hubs1.com.secure.encrypt.Encrypt;
import net.hubs1.com.secure.encrypt.EncryptFactory;

/**
 * @Description 测试类
 * @author weqinjia.liu
 * @Date 2016年8月31日
 */
public class TestEncrypt {
    private static Encrypt encrypt = null;

    static {
        encrypt = EncryptFactory.getEncrypt(EncryptFactory.Encrypt_AES);
    }

    public static void main(String[] args) {
        String str = "h12!@#$%^&*()_+345daadsa6";
        String key = "180126313066";
        String encrypt_pwd = encrypt(str, key);
        System.out.println(encrypt_pwd);
        decrypt(encrypt_pwd, key);
    }

    private static void decrypt(String str, String key) {
        String decrypt = encrypt.decrypt(str, key);
        System.out.println(decrypt);
    }

    private static String encrypt(String str, String key) {
        return encrypt.encrypt(str, key);
    }

}
