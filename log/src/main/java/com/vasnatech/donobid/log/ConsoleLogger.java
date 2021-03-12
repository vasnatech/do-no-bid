package com.vasnatech.donobid.log;

public class ConsoleLogger implements Logger {

    @Override
    public void trace(String message) {
        println(message);
    }

    @Override
    public void info(String message) {
        println(message);
    }

    @Override
    public void warning(Throwable thrown, String message) {
        println(message);
        println(thrown);
    }

    @Override
    public void error(Throwable thrown, String message) {
        println(message);
        println(thrown);
    }

    @Override
    public void fatal(Throwable thrown, String message) {
        println(message);
        println(thrown);
    }


    void println(String message) {
        if (message != null)
            System.out.println(message);
    }

    void println(Throwable thrown) {
        if (thrown != null)
            thrown.printStackTrace();
    }
}
