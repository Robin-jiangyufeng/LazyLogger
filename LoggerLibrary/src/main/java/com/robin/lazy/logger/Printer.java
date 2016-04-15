package com.robin.lazy.logger;

/***
 * 打印处理基类
 * 
 * @author  jiangyufeng
 * @version  [版本号, 2015年11月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface Printer {

	Printer t(String tag, int methodCount);

	Settings init(String tag);

	Settings getSettings();

	void d(String message, Object... args);
	
	void d(Throwable throwable, String message, Object... args);

	void e(String message, Object... args);

	void e(Throwable throwable, String message, Object... args);

	void w(String message, Object... args);
	
	void w(Throwable throwable, String message, Object... args);

	void i(String message, Object... args);
	
	void i(Throwable throwable, String message, Object... args);

	void v(String message, Object... args);
	
	void v(Throwable throwable, String message, Object... args);

	void wtf(String message, Object... args);
	
	void wtf(Throwable throwable, String message, Object... args);

	void json(String json);

	void xml(String xml);

	void clear();
}
