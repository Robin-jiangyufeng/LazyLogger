/*
 * 文 件 名:  LoggerPrinterFactory.java
 * 版    权:  Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  jiangyufeng
 * 修改时间:  2015年11月24日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.robin.lazy.logger;
/**
 * 打印工厂方法
 * 
 * @author  jiangyufeng
 * @version  [版本号, 2015年11月24日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class LoggerPrinterFactory {
	
	/**
	 * 获取一个打印器
	 * @param printerType
	 * @return
	 * Printer
	 * @throws
	 * @see [类、类#方法、类#成员]
	 */
    public static Printer getPrinter(PrinterType printerType){
    	if(printerType==PrinterType.ORDINARY){
    		return new LoggerOrdinaryPrinter();
    	}else{
    		return new LoggerFormattedPrinter();
    	}
    }
	
}

