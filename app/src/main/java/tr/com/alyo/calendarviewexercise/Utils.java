package tr.com.alyo.calendarviewexercise;

import java.text.SimpleDateFormat;
import java.util.Date;
    
class Utils {

    private static final String LOG_TAG = Utils.class.getSimpleName();

    static String dateConverter(long unixTime){


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

        String newDate = formatter.format(unixTime);

        return newDate;

    }



}
