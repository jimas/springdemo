package net.hubs1.com.secure.encrypt;

public class EncryptException extends RuntimeException {

	private static final long serialVersionUID = -1807298646168658137L;

	public EncryptException() {
	}

	public EncryptException(String message) {
		super(message);
	}

	public EncryptException(Throwable e) {
		super(e);
	}

	public EncryptException(String message, Throwable e) {
		super(message, e);
	}
}