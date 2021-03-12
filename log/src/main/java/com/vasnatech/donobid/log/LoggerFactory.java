package com.vasnatech.donobid.log;

import java.util.HashMap;
import java.util.Map;

public interface LoggerFactory {

    Map<String, LoggerFactory> FACTORIES = new HashMap<>();
    static LoggerFactory getDefault() {
        return FACTORIES.get(null);
    }
    static void setDefault(LoggerFactory factory) {
        FACTORIES.put(null, factory);
    }
    static LoggerFactory get(String key) {
        return FACTORIES.getOrDefault(key, getDefault());
    }
    static void set(String key, LoggerFactory factory) {
        FACTORIES.put(key, factory);
    }


    static Logger getLogger() {
        LoggerFactory loggerFactory = getDefault();
        if (loggerFactory == null)
            throw new IllegalArgumentException("Unable to find default logger factory");
        return loggerFactory.create();
    }

    static Logger getLogger(String key) {
        LoggerFactory loggerFactory = get(key);
        if (loggerFactory == null)
            throw new IllegalArgumentException("Unable to find logger factory for " + key);
        return loggerFactory.create();
    }


    Logger create();
}
