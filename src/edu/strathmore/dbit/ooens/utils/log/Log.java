package edu.strathmore.dbit.ooens.utils.log;

import java.time.LocalDateTime;

public class Log {

    public static void v(String message) {
        log(LogLevel.VERBOSE, message, null);
    }

    public static void v(String message, Object tag) {
        log(LogLevel.VERBOSE, message, tag);
    }

    public static void d(String message) {
        log(LogLevel.DEBUG, message, null);
    }

    public static void d(String message, Object tag) {
        log(LogLevel.DEBUG, message, tag);
    }

    public static void i(String message) {
        log(LogLevel.INFO, message, null);
    }

    public static void i(String message, Object tag) {
        log(LogLevel.INFO, message, tag);
    }

    public static void w(String message) {
        log(LogLevel.WARNING, message, null);
    }

    public static void w(String message, Object tag) {
        log(LogLevel.WARNING, message, tag);
    }

    public static void e(String message) {
        log(LogLevel.ERROR, message, null);
    }

    public static void e(String message, Object tag) {
        log(LogLevel.ERROR, message, tag);
    }

    private static String getTimestamp() {
        final LocalDateTime now = LocalDateTime.now();
        final String date = String.format(
                "%d:%02d:%02d",
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth()
        );

        final String time = String.format(
                "%02d:%02d:%02d.%06d",
                now.getHour(),
                now.getMinute(),
                now.getSecond(),
                now.getNano() / 1000
        );

        return String.format("%sT%s", date, time);
    }

    private static void log(LogLevel level, String message, Object tag) {
        final String timestamp = getTimestamp();
        final char label = level.toString().charAt(0);
        String output = String.format("[%s]-[%s]", timestamp, label);

        if (tag != null) {
            output += String.format("-[%s]", tag.getClass().getSimpleName());
        }

        output = String.format("%s: %s", output, message);

        final boolean isError = level == LogLevel.ERROR;
        (isError ? System.err : System.out).println(output);
    }
}
