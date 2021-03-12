package com.vasnatech.donobid.log;

public interface Logger {

    void trace(String message);

    default void trace(String message, Object... args) {
        trace(format(message, args));
    }

    void info(String message);

    default void info(String message, Object... args) {
        info(format(message, args));
    }

    default void warning(String message) {
        warning(null, message);
    }

    default void warning(String message, Object... args) {
        warning(format(message, args));
    }

    default void warning(Throwable thrown) {
        warning(thrown, null);
    }

    void warning(Throwable thrown, String message);

    default void warning(Throwable thrown, String message, Object... args) {
        warning(thrown, format(message, args));
    }

    default void error(String message) {
        error(null, message);
    }

    default void error(String message, Object... args) {
        error(format(message, args));
    }

    default void error(Throwable thrown) {
        error(thrown, null);
    }

    void error(Throwable thrown, String message);

    default void error(Throwable thrown, String message, Object... args) {
        error(thrown, format(message, args));
    }

    default void fatal(String message) {
        fatal(null, message);
    }

    default void fatal(String message, Object... args) {
        fatal(format(message, args));
    }

    default void fatal(Throwable thrown) {
        fatal(thrown, null);
    }

    void fatal(Throwable thrown, String message);

    default void fatal(Throwable thrown, String message, Object... args) {
        fatal(thrown, format(message, args));
    }


    default String format(String message, Object... args) {
        return String.format(message, args);
    }





    static Logger getLogger() {
        return LoggerFactory.getLogger();
    }

    static Logger getLogger(String key) {
        return LoggerFactory.getLogger(key);
    }
}
