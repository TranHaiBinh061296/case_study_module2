package vn.thbinh.furniture.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InstantUtils {
    //định dạng ngày tháng năm
    private static final String PATTEN_FORMAT = "HH:mm dd-MM-yyyy";
    public static String instantToString(Instant instant) {
        return instantToString(instant, null);
    }
    public static String instantToString(Instant instant, String patternFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternFormat != null ? patternFormat : PATTEN_FORMAT).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }
}
