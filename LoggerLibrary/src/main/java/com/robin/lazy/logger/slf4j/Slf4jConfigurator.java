package com.robin.lazy.logger.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.android.LogcatAppender;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;

/**
 * Created by zhangyunfei on 15/9/21.
 */
public class Slf4jConfigurator {
//    private static final String DEFAULT_PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n";
    private static final String DEFAULT_PATTERN = "%d - [%p::%c] - %m%n"/*"%d - [%p::%c::%t] - %m%n"*/;
    private Level level;
    /**
     * 日志打印出来的样式
     */
    private String logPattern;
    /**
     * 打印到本地文件
     */
    private String fileNamePattern;

    public Slf4jConfigurator() {
        logPattern = DEFAULT_PATTERN;
    }

    /**
     * 设置日志级别
     *
     * @param level
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * 设置打印到本地的文件
     */
    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    /**
     * 执行配置
     */
    public void configure() {
        // reset the default context (which may already have been initialized)
        // since we want to reconfigure it
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<ILoggingEvent>();
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setContext(context);

        // OPTIONAL: Set an active log file (separate from the rollover files).
        // If rollingPolicy.fileNamePattern already set, you don't need this.
        //rollingFileAppender.setFile(LOG_DIR + "/log.txt");
        TimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new TimeBasedRollingPolicy<ILoggingEvent>();
        rollingPolicy.setFileNamePattern(fileNamePattern);
        rollingPolicy.setMaxHistory(7);
        rollingPolicy.setParent(rollingFileAppender);  // parent and context required!
        rollingPolicy.setContext(context);
        rollingPolicy.start();

        rollingFileAppender.setRollingPolicy(rollingPolicy);

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern(logPattern);
        encoder.setContext(context);
        encoder.start();

        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.start();

        LogcatAppender logcatAppender = new LogcatAppender();
        logcatAppender.setContext(context);
        logcatAppender.setEncoder(encoder);
        logcatAppender.setName("logcat");
        logcatAppender.start();

        // add the newly created appenders to the root logger;
        // qualify Logger to disambiguate from org.slf4j.Logger
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(level);
        root.addAppender(rollingFileAppender);
        root.addAppender(logcatAppender);

        // print any status messages (warnings, etc) encountered in logback config
        //StatusPrinter.print(context);
    }


}
