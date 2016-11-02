package net.hubs1.com.secure.encrypt;

public abstract interface Encrypt {
    
	/**
	 * 加密
	 * @param str
	 * @param key 16 字节
	 * @return
	 * @throws EncryptException
	 */
	public abstract String encrypt(String str, String key)
			throws EncryptException;

	/**
	 * 解密
	 * @param str
	 * @param key
	 * @return
	 * @throws EncryptException
	 */
	public abstract String decrypt(String str, String key)
			throws EncryptException;
}