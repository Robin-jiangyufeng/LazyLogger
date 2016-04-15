/*
 * 文 件 名:  Log4JTool.java
 * 版    权:  Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  jiangyufeng
 * 修改时间:  2015年11月23日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.robin.lazy.logger;

import android.os.Environment;

import com.robin.lazy.logger.slf4j.Slf4jConfigurator;

import org.slf4j.LoggerFactory;

import java.io.File;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * Log4J的适配器
 *
 * @author jiangyufeng
 * @version [版本号, 2015年11月23日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SLF4JTool implements LogTool {
    private Logger log;
    private String curTag;
    private Level mLevel;

    public SLF4JTool() {
        this(Level.ERROR);
    }

    /**
     * <默认构造函数>
     *
     * @param level log4j中的日志等级
     */
    public SLF4JTool(Level level) {
        this(level, "MyLog", "applog");
    }

    public SLF4JTool(Level level, String dirName, String fileName) {
        this.mLevel = level;
        Slf4jConfigurator logConfigurator = new Slf4jConfigurator();
        fileName += "_%d{yyyyMMdd}";
        logConfigurator.setFileNamePattern(getFile(dirName, fileName));
        // Set the root log level
        // 只有级别大于或等于level的日志记录消息才会得到处理。所有其他的消息都将被忽略。
        logConfigurator.setLevel(level);
        logConfigurator.configure();
    }

    @Override
    public void d(String tag, String message) {
        resetLog(tag);
        log.debug(message);
    }

    @Override
    public void d(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.debug(message, throwable);
    }

    @Override
    public void e(String tag, String message) {
        resetLog(tag);
        log.error(message);
    }

    @Override
    public void e(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.error(message, throwable);
    }

    @Override
    public void w(String tag, String message) {
        resetLog(tag);
        log.warn(message);
    }

    @Override
    public void w(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.warn(message, throwable);

    }

    @Override
    public void i(String tag, String message) {
        resetLog(tag);
        log.info(message);
    }

    @Override
    public void i(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.info(message, throwable);
    }

    @Override
    public void v(String tag, String message) {
        resetLog(tag);
        log.trace(message);
    }

    @Override
    public void v(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.trace(message, throwable);
    }

    @Override
    public void wtf(String tag, String message) {
        resetLog(tag);
        log.debug(message);
    }

    @Override
    public void wtf(String tag, String message, Throwable throwable) {
        resetLog(tag);
        log.debug(message, throwable);
    }

    /**
     * 获取文件路径
     *
     * @return
     */
    private String getFile(String dirName, String fileName) {
        String sdDir = null;
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            sdDir = Environment.getExternalStorageDirectory().toString();
        }
        File cacheDir = new File(sdDir + File.separator + dirName);
        if (!cacheDir.exists())
            cacheDir.mkdir();
        File filePath = new File(cacheDir + File.separator + fileName + ".log");
        return filePath.toString();
    }

    /***
     * 重置log工具
     *
     * @param tag void
     * @throws
     * @see [类、类#方法、类#成员]
     */
    private void resetLog(String tag) {
        if (curTag == null) {
            this.curTag = tag;
            log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(tag);
            log.setLevel(mLevel);
        } else if (!curTag.equals(tag)) {
            this.curTag = tag;
            log = null;
            log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(tag);
            log.setLevel(mLevel);
        }
    }
}
