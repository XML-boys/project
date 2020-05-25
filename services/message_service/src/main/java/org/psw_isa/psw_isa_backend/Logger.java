package org.psw_isa.psw_isa_backend;

public class Logger {
	private static Logger instance = null;

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	private Logger() {
	}

	public void debug(String msg) {
		System.out.println("[DEBUG] " + msg);
	}
	public void info(String msg) {
		System.out.println("[INFO] " + msg);
	}
	public void error(String msg) {
		System.out.println("[ERROR] " + msg);
	}
	public void warning(String msg) {
		System.out.println("[WARN] " + msg);
	}
}
