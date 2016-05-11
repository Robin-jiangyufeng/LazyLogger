package com.robin.lazy.logger;

public enum LogLevel {

    /**
     * 输出所有类型日志
     */
    ALL(0),

    /**
     * trace类型日志
     */
    TRACE(1),

    /**
     * debug类型日志
     */
    DEBUG(2),

    /**
     * info类型日志
     */
    INFO(3),

    /**
     * warn类型日志
     */
    WARN(4),

    /**
     * error类型日志
     */
    ERROR(5),

    /**
     * fatal类型日志
     */
    FATAL(6),

    /**
     * 关闭日志输出
     */
    OFF(7);

    private int code;

    private LogLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
