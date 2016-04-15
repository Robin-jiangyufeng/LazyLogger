package com.robin.lazy.logger;

/**
 * Logger is a wrapper of {@link android.util.Log} But more pretty, simple and
 * powerful
 */
public final class LazyLogger {
	private static final String DEFAULT_TAG = "LazyLogger";

	private static Printer printer = new LoggerFormattedPrinter();

	// no instance
	private LazyLogger() {
	}

	/**
	 * It is used to get the settings object in order to change settings
	 *
	 * @return the settings object
	 */
	public static Settings init(PrinterType printerType) {
		return init(DEFAULT_TAG, printerType);
	}

	/**
	 * It is used to change the tag
	 *
	 * @param tag
	 *            is the given string which will be used in Logger as TAG
	 */
	public static Settings init(String tag, PrinterType printerType) {
		if(printer!=null){
			clear();
		}
		printer = LoggerPrinterFactory.getPrinter(printerType);
		return printer.init(tag);
	}

	public static void clear() {
		printer.clear();
		printer = null;
	}

	public static Printer t(String tag) {
		return printer.t(tag, printer.getSettings().getMethodCount());
	}

	public static Printer t(int methodCount) {
		return printer.t(null, methodCount);
	}

	public static Printer t(String tag, int methodCount) {
		return printer.t(tag, methodCount);
	}

	public static void d(String message, Object... args) {
		printer.d(message, args);
	}

	public static void d(Throwable throwable, String message, Object... args) {
		printer.d(throwable, message, args);
	}

	public static void e(String message, Object... args) {
		printer.e(null, message, args);
	}

	public static void e(Throwable throwable, String message, Object... args) {
		printer.e(throwable, message, args);
	}

	public static void i(String message, Object... args) {
		printer.i(message, args);
	}

	public static void i(Throwable throwable, String message, Object... args) {
		printer.i(throwable, message, args);
	}

	public static void v(String message, Object... args) {
		printer.v(message, args);
	}

	public static void v(Throwable throwable, String message, Object... args) {
		printer.v(throwable, message, args);
	}

	public static void w(String message, Object... args) {
		printer.w(message, args);
	}

	public static void w(Throwable throwable, String message, Object... args) {
		printer.w(throwable, message, args);
	}

	public static void wtf(String message, Object... args) {
		printer.wtf(message, args);
	}

	public static void wtf(Throwable throwable, String message, Object... args) {
		printer.wtf(throwable, message, args);
	}

	/**
	 * Formats the json content and print it
	 *
	 * @param json
	 *            the json content
	 */
	public static void json(String json) {
		printer.json(json);
	}

	/**
	 * Formats the json content and print it
	 *
	 * @param xml
	 *            the xml content
	 */
	public static void xml(String xml) {
		printer.xml(xml);
	}

}
