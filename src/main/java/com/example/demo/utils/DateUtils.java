package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String dealDateFormat(String oldDate){
        DateFormat df2 = null;
        String newDate = "";
        try {
            oldDate= oldDate.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm");
            Date date = df.parse(oldDate);
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            newDate = df2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    public static String dealDateForDB(String webDate){
        String dbDate = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(webDate);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm");
            String dbdate = df.format(date);
            dbDate = dbdate.replace(" UTC","Z");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dbDate;
    }
}
