/*
 * 文 件 名:  LoggerOrdinaryPrinter.java
 * 版    权:  Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  jiangyufeng
 * 修改时间:  2015年11月24日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.robin.lazy.logger;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

/**
 * 普通的打印器
 * 
 * @author jiangyufeng
 * @version [版本号, 2015年11月24日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoggerOrdinaryPrinter implements Printer {
	/**
	 * It is used for json pretty print
	 */
	private static final int JSON_INDENT = 4;

	/**
	 * tag is used for the Log, the name is a little different in order to
	 * differentiate the logs easily with the filter
	 */
	private String tag;

	/**
	 * It is used to determine log settings such as method count, thread info
	 * visibility
	 */
	private Settings settings;
	
	/**
	 * Localize single tag and method count for each thread
	 */
	private final ThreadLocal<String> localTag = new ThreadLocal<String>();

	@Override
	public Printer t(String tag, int methodCount) {
		if (tag != null) {
			localTag.set(tag);
		}
		return this;
	}

	@Override
	public Settings init(String tag) {
		if (tag == null) {
			throw new NullPointerException("tag may not be null");
		}
		if (tag.trim().length() == 0) {
			throw new IllegalStateException("tag may not be empty");
		}
		this.tag = tag;
		this.settings = new Settings();
		return settings;
	}

	@Override
	public Settings getSettings() {
		return settings;
	}

	@Override
	public void d(String message, Object... args) {
		log(LogLevel.DEBUG, message, args);
	}

	@Override
	public void d(Throwable throwable, String message, Object... args) {
		log(LogLevel.DEBUG, throwable, message, args);
	}

	@Override
	public void e(String message, Object... args) {
		log(LogLevel.ERROR, message, args);
	}

	@Override
	public void e(Throwable throwable, String message, Object... args) {
		log(LogLevel.ERROR, throwable, message, args);
	}

	@Override
	public void w(String message, Object... args) {
		log(LogLevel.WARN, message, args);
	}

	@Override
	public void w(Throwable throwable, String message, Object... args) {
		log(LogLevel.WARN, throwable, message, args);
	}

	@Override
	public void i(String message, Object... args) {
		log(LogLevel.INFO, message, args);
	}

	@Override
	public void i(Throwable throwable, String message, Object... args) {
		log(LogLevel.INFO, throwable, message, args);
	}

	@Override
	public void v(String message, Object... args) {
		log(LogLevel.TRACE, message, args);
	}

	@Override
	public void v(Throwable throwable, String message, Object... args) {
		log(LogLevel.TRACE, throwable, message, args);
	}

	@Override
	public void wtf(String message, Object... args) {
		log(LogLevel.FATAL, message, args);
	}

	@Override
	public void wtf(Throwable throwable, String message, Object... args) {
		log(LogLevel.FATAL, throwable, message, args);
	}

	@Override
	public void json(String json) {
		if (TextUtils.isEmpty(json)) {
			d("Empty/Null json content");
			return;
		}
		try {
			if (json.startsWith("{")) {
				JSONObject jsonObject = new JSONObject(json);
				String message = jsonObject.toString(JSON_INDENT);
				d(message);
				return;
			}
			if (json.startsWith("[")) {
				JSONArray jsonArray = new JSONArray(json);
				String message = jsonArray.toString(JSON_INDENT);
				d(message);
			}
		} catch (JSONException e) {
			e(e.getCause().getMessage() + "\n" + json);
		}
	}

	@Override
	public void xml(String xml) {
		if (TextUtils.isEmpty(xml)) {
			d("Empty/Null xml content");
			return;
		}
		try {
			Source xmlInput = new StreamSource(new StringReader(xml));
			StreamResult xmlOutput = new StreamResult(new StringWriter());
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(xmlInput, xmlOutput);
			d(xmlOutput.getWriter().toString().replaceFirst(">", ">\n"));
		} catch (TransformerException e) {
			e(e.getCause().getMessage() + "\n" + xml);
		}
	}

	@Override
	public void clear() {
		settings = null;
	}

	/**
	 * 打印log
	 * 
	 * @param logType
	 *            log类型
	 * @param message
	 * @param args
	 *            void
	 * @throws
	 * @see [类、类#方法、类#成员]
	 */
	private void log(LogLevel logType, String message, Object... args) {
		log(logType, null, message, args);
	}

	/**
	 * 打印log
	 * 
	 * @param logType
	 *            log类型
	 * @param throwable
	 *            异常
	 * @param message
	 * @param args
	 *            void
	 * @throws
	 * @see [类、类#方法、类#成员]
	 */
	private void log(LogLevel logType, Throwable throwable, String message,
			Object... args) {
		if (settings == null
				|| settings.getLogLevel().getCode() > logType.getCode()) {
			// 如果设置的打印日志级别大于当前打印日志的级别则取消打印
			return;
		}
		String finalMessage = createMessage(message, args);
		switch (logType) {
			case TRACE :
				if (throwable != null) {
					settings.getLogTool().v(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().v(getTag(), finalMessage);
				}
				break;
			case DEBUG :
				if (throwable != null) {
					settings.getLogTool().d(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().d(getTag(), finalMessage);
				}
				break;
			case INFO :
				if (throwable != null) {
					settings.getLogTool().i(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().i(getTag(), finalMessage);
				}
				break;
			case WARN :
				if (throwable != null) {
					settings.getLogTool().w(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().w(getTag(), finalMessage);
				}
				break;
			case ERROR :
				if (throwable != null) {
					settings.getLogTool().e(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().e(getTag(), finalMessage);
				}
				break;
			case FATAL :
				if (throwable != null) {
					settings.getLogTool().wtf(getTag(), finalMessage, throwable);
				} else {
					settings.getLogTool().wtf(getTag(), finalMessage);
				}
				break;
			default :
				break;
		}
	}

	private String createMessage(String message, Object... args) {
		return args.length == 0 ? message : String.format(message, args);
	}

	/**
	 * @return the appropriate tag based on local or global
	 */
	private String getTag() {
		String tag = localTag.get();
		if (tag != null) {
			localTag.remove();
			return tag;
		}
		return this.tag;
	}
}
