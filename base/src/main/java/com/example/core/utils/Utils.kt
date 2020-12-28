package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * Created by Bony on 12/24/20.
 */

private val displayMetrics = Resources.getSystem().displayMetrics

fun Float.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this,
    displayMetrics)

object Utils {
    // 如果没有此注解，会让Java调用单参数构造函数失败
    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}