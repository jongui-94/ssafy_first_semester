package com.ssafy.memo.util

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    // Java의 static method와 동일
    companion object{
        fun formatter(): SimpleDateFormat {
            val formatter = SimpleDateFormat("MM-dd hh:mm")
            formatter.timeZone = TimeZone.getTimeZone("GMT+9")

            return formatter
        }
    }
}