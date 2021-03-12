package com.vasnatech.donobid.log;

public class CompoundLogger implements Logger {

    Logger[] loggers;

    public CompoundLogger(Logger...loggers) {
        this.loggers = loggers;
    }


    @Override
    public void trace(String message) {
        for (Logger logger : loggers)
            logger.trace(message);
    }

    @Override
    public void info(String message) {
        for (Logger logger : loggers)
            logger.info(message);
    }

    @Override
    public void warning(Throwable thrown, String message) {
        for (Logger logger : loggers)
            logger.warning(thrown, message);
    }

    @Override
    public void error(Throwable thrown, String message) {
        for (Logger logger : loggers)
            logger.error(thrown, message);
    }

    @Override
    public void fatal(Throwable thrown, String message) {
        for (Logger logger : loggers)
            logger.fatal(thrown, message);
    }
}
