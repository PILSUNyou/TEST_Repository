package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

class util {
    public static String getNowDateStr() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return formatter.format(now);
    }
}
