package com.esampaio.apps.contadordecafe.util

import java.util.*

/**
 * Created by Eduardo on 20/05/2017.
 */
class DateUtil {
    companion object{
        fun setDateAndTime(date:Date,hours:Int,minutes:Int):Date {
            var cal = Calendar.getInstance();
            cal.time = date;
            cal.apply {
                set(Calendar.HOUR_OF_DAY,hours)
                set(Calendar.MINUTE,minutes)
                set(Calendar.SECOND,0)
                set(Calendar.MILLISECOND,0)
            }
            return cal.time;
        }
    }
}
