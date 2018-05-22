package com.ulvhamne;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This is the type com.ulvhamne.February30.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2018-02-08
 */
public class February30 {
    public static  void main(String... args) {
        final Calendar calendar = new GregorianCalendar();
        calendar.set(1712, Calendar.FEBRUARY,30); //This date actually existed.
        final Date time = calendar.getTime();
        System.out.println(time);
    }
}
