package net.hubs1.com.secure.encrypt;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import net.hubs1.com.utils.CutString;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class EncryptAES implements Encrypt {
    private  static final int  keyLength=16;
    private static final String[] keyValues={"@","!","p","w","d","M","A","S","+","=","-","P","(",")","*","&"};
    private static final String charsetName="UTF-8";
	public String encrypt(String str, String key) throws EncryptException {
		try {
		    key = handleKey(key);
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");

			Cipher c = Cipher.getInstance("AES");

			c.init(Cipher.ENCRYPT_MODE, keyspec);

			byte[] src = str.getBytes(charsetName);

			byte[] encrypt = c.doFinal(src);

			return new BASE64Encoder().encode(encrypt).replaceAll("\r|\n", "");
		} catch (Exception e) {
			throw new EncryptException("Encrypt failed.", e);
		}
	}


	public String decrypt(String str, String key) throws EncryptException {
		try {
		    key = handleKey(key);
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");

			Cipher c = Cipher.getInstance("AES");

			c.init(2, keyspec);

			byte[] decode = new BASE64Decoder().decodeBuffer(str);

			byte[] decrypt = c.doFinal(decode);

			return new String(decrypt, charsetName);
		} catch (Exception e) {
			throw new EncryptException("Decrypt failed.", e);
		}
	}

    private String handleKey(String key) throws UnsupportedEncodingException {
        int len = getUTFLength(key);
        if(len>keyLength){
            key= CutString.substring(key, keyLength,charsetName);
            len = getUTFLength(key);
        }
        if(len<keyLength){
            for(int i=0;i<keyLength-len;i++){
                key=key+keyValues[i];
            }
           
        }
        return key;
    }


    private int getUTFLength(String key) throws UnsupportedEncodingException {
        int len=StringUtils.isEmpty(key)?0:key.getBytes(charsetName).length;
        return len;
    }
}