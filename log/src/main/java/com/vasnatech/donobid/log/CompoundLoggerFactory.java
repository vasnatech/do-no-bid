package com.vasnatech.donobid.log;

import java.util.stream.Stream;

public class CompoundLoggerFactory implements LoggerFactory {

    LoggerFactory[] loggerFactories;
    CompoundLogger compoundLogger;

    public CompoundLoggerFactory(LoggerFactory... loggerFactories) {
        this.loggerFactories = loggerFactories;
    }

    @Override
    public synchronized Logger create() {
        if (compoundLogger == null)
            compoundLogger = new CompoundLogger(
                Stream.of(loggerFactories)
                    .map(LoggerFactory::create)
                    .toArray(Logger[]::new)
            );
        return compoundLogger;
    }
}
