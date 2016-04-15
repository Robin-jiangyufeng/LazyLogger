/*
 * 文 件 名:  LazyAppliction.java
 * 版    权:  Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  江钰锋 00501
 * 修改时间:  16/4/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.robin.lazy.sample;

import android.app.Application;

import com.robin.lazy.logger.LazyLogger;
import com.robin.lazy.logger.Log4JTool;
import com.robin.lazy.logger.LogLevel;
import com.robin.lazy.logger.PrinterType;
import com.robin.lazy.logger.SLF4JTool;

import org.apache.log4j.Level;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author 江钰锋 00501
 * @version [版本号, 16/4/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class LazyAppliction extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    /***
     * 初始化日志系统
     *
     * @throws
     * @see [类、类#方法、类#成员]
     */
    protected void initLogger() {
        LazyLogger.init(PrinterType.FORMATTED/*PrinterType.ORDINARY*/) // 打印类型
                .methodCount(3) // default 2
                .hideThreadInfo() // default shown
                .logLevel(LogLevel.ALL) // default LogLevel.ALL(设置全局日志等级)
                .methodOffset(2) // default 0
                .logTool(/* new AndroidLogTool() *//*new SLF4JTool()*/new Log4JTool(Level.ALL)); // Log4j中的Level与本框架的LogLevel是分开设置的(Level只用来设置log4j的日志等级)
    }
}
