package com.mt.lib_common.util

import android.annotation.SuppressLint
import android.app.Application
import java.util.*
import kotlin.math.acos

/**
 *  @author : MaoTong
 *  @date : 2020/9/16 10:44
 *  description :
 */

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/16 10:44
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
object AppGlobals {
    var sApplication: Application? = null
        @SuppressLint("PrivateApi", "DiscouragedPrivateApi")
        get() {
            if (field == null) {
                val aClass = Class.forName("android.app.ActivityThread")
                val currentApplication = aClass.getDeclaredMethod("currentApplication")
                field = currentApplication.invoke(null) as Application?
                return field
            }
            return field
        }
}