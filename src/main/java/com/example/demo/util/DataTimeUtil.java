package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final String DEFAULT_PATTERN =
            "yyyy-MM-dd HH:mm:ss";

    private DateTimeUtil() {
        // prevent object creation
    }

    // Get current date & time
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    // Format LocalDateTime to String
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(
                DateTimeFormatter.ofPattern(DEFAULT_PATTERN)
        );
    }

    // Parse String to LocalDateTime
    public static LocalDateTime parse(String dateTime) {
        return LocalDateTime.parse(
                dateTime,
                DateTimeFormatter.ofPattern(DEFAULT_PATTERN)
        );
    }
}
