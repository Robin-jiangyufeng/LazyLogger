package com.robin.lazy.logger;

import android.util.Log;

public class AndroidLogTool implements LogTool {
	/**
	 * 一次日志最大打印长度
	 */
	private final static int MAX_LENGTH=3000;
	@Override
	public void d(String tag, String message) {
		while (message.length()>MAX_LENGTH){
			Log.d(tag, message.substring(0,MAX_LENGTH) );
			message=message.substring(MAX_LENGTH);
		}
		//剩余部分
		Log.d(tag, message);
	}

	@Override
	public void d(String tag, String message, Throwable throwable) {
		while (message.length()>MAX_LENGTH){
			Log.d(tag, message.substring(0,MAX_LENGTH) ,throwable);
			message=message.substring(MAX_LENGTH);
		}
		//剩余部分
		Log.d(tag, message, throwable);
	}

	@Override
	public void e(String tag, String message) {
		Log.e(tag, message);
	}

	@Override
	public void e(String tag, String message, Throwable throwable) {
		Log.e(tag, message, throwable);
	}

	@Override
	public void w(String tag, String message) {
		Log.w(tag, message);
	}

	@Override
	public void w(String tag, String message, Throwable throwable) {
		Log.w(tag, message, throwable);
	}

	@Override
	public void i(String tag, String message) {
		Log.i(tag, message);
	}

	@Override
	public void i(String tag, String message, Throwable throwable) {
		Log.i(tag, message, throwable);
	}

	@Override
	public void v(String tag, String message) {
		Log.v(tag, message);
	}

	@Override
	public void v(String tag, String message, Throwable throwable) {
		Log.v(tag, message, throwable);
	}

	@Override
	public void wtf(String tag, String message) {
		Log.wtf(tag, message);
	}

	@Override
	public void wtf(String tag, String message, Throwable throwable) {
		Log.wtf(tag, message, throwable);
	}

}
