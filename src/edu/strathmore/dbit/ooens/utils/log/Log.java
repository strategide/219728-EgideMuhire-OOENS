package edu.strathmore.dbit.ooens.utils.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public static void v(Object message) {
        log(LogLevel.VERBOSE, message, null);
    }

    public static void v(Object message, String tag) {
        log(LogLevel.VERBOSE, message, tag);
    }

    public static void d(Object message) {
        log(LogLevel.DEBUG, message, null);
    }

    public static void d(Object message, String tag) {
        log(LogLevel.DEBUG, message, tag);
    }

    public static void i(Object message) {
        log(LogLevel.INFO, message, null);
    }

    public static void i(Object message, String tag) {
        log(LogLevel.INFO, message, tag);
    }

    public static void w(Object message) {
        log(LogLevel.WARNING, message, null);
    }

    public static void w(Object message, String tag) {
        log(LogLevel.WARNING, message, tag);
    }

    public static void e(Object message) {
        log(LogLevel.ERROR, message, null);
    }

    public static void e(Object message, String tag) {
        log(LogLevel.ERROR, message, tag);
    }

    private static void log(LogLevel level, Object message, String tag) {
        final String timestamp = getTimestamp();
        final char label = level.toString().charAt(0);
        String output = String.format("[%s]-[%s]", timestamp, label);

        if (tag != null && !tag.isBlank()) {
            output += String.format("-[%s]", tag);
        }

        output = String.format("%s: %s", output, message);

        final boolean isError = level == LogLevel.ERROR;
        (isError ? System.err : System.out).println(output);
    }

    private static String getTimestamp() {
        final LocalDateTime timestamp = LocalDateTime.now();
        return timestamp.format(formatter);
    }
}
