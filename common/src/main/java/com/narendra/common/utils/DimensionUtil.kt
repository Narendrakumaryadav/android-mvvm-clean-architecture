package com.narendra.common.utils

import android.content.res.Resources

object DimensionUtil {

    /**
     * returns the amount pixels for a dimension in dp
     * http://stackoverflow.com/a/9685690
     */
    @JvmStatic
    fun getDPinPixels(dp: Int, resources: Resources?): Int {
        if (resources == null) {
            return 0
        }

        val scale = resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}