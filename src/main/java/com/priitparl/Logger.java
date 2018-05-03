package com.priitparl;


import java.util.List;

public class Logger {

    private static Logger instance;
    private Logger() {}

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void printResults(List<String> values) {
        values.forEach(System.out::println);
    }
}
