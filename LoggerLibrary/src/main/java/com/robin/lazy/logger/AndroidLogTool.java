package com.robin.lazy.logger;

import android.util.Log;

public class AndroidLogTool implements LogTool {
	
	@Override
	public void d(String tag, String message) {
		Log.d(tag, message);
	}

	@Override
	public void d(String tag, String message, Throwable throwable) {
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
