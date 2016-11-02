package net.hubs1.com.secure.encrypt;

public class EncryptNONE implements Encrypt {
	public String encrypt(String str, String key) throws EncryptException {
		return str;
	}

	public String decrypt(String str, String key) throws EncryptException {
		return str;
	}
}