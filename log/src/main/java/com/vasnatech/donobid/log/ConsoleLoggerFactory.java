package com.vasnatech.donobid.log;

public class ConsoleLoggerFactory implements LoggerFactory {

    static ConsoleLogger consoleLogger = null;

    @Override
    public synchronized Logger create() {
        if (consoleLogger == null)
            consoleLogger = new ConsoleLogger();
        return consoleLogger;
    }
}
