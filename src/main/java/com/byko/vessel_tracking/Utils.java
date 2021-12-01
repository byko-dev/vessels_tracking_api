package com.byko.vessel_tracking;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String setDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm a");
        return simpleDateFormat.format(date);
    }
}
