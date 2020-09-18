package com.mt.githubbrowser.binding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * ================================================
 *  @author : MaoTong
 *  @date : 2020/9/18 15:29
 *  description :
 * <a href="mailto:ytumaotong@gmail.com">Contact me</a>
 * <a href="https://github.com/Crazy-MT">Follow me</a>
 * ================================================
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}