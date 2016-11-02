package net.hubs1.com.secure.encrypt;

public class EncryptFactory {
	public static final String Encrypt_NONE = "NONE";
	public static final String Encrypt_AES = "AES";

	public static Encrypt getEncrypt(String encryptName) {
		if ("NONE".equals(encryptName)) {
			return new EncryptNONE();
		}
		if ("AES".equals(encryptName)) {
			return new EncryptAES();
		}

		throw new EncryptException("Unknown encryptName:" + encryptName);
	}
}