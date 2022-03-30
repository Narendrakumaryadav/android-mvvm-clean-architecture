package com.narendra.comman.utils.extensions

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.*
import kotlin.math.abs

fun View.hideKeyBoard() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.requestFocusAndShowKeyboard() {
    requestFocus()
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

private const val BETTER_SMOOTH_SCROLL_SPEED_MODIFIER = 4.0f

fun ScrollView.betterSmoothScrollTo(
    x: Int, y: Int, speedModifier: Float = BETTER_SMOOTH_SCROLL_SPEED_MODIFIER
) {
    if (scrollX != x) {
        ObjectAnimator.ofInt(this, "scrollX", x)
            .apply {
                duration = ((abs(scrollX - x) / speedModifier) + 0.5f).toLong()
                start()
            }
    }
    if (scrollY != y) {
        ObjectAnimator.ofInt(this, "scrollY", y)
            .apply {
                duration = ((abs(scrollY - y) / speedModifier) + 0.5f).toLong()
                start()
            }
    }
}

inline fun linearLayoutParams(
    width: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    height: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    block: LinearLayout.LayoutParams.() -> Unit
): LinearLayout.LayoutParams {
    val params = LinearLayout.LayoutParams(width, height)
    params.block()
    return params
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    block: (T1, T2) -> R?
): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun <T, L : LiveData<T>> Fragment.observe(liveData: L, body: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(body))
}

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            removeObserver(this)
            observer.onChanged(t)
        }
    })
}

fun Activity.hideKeyBoard() {
    currentFocus?.hideKeyBoard()
}

fun String.capitalizeFirstLetter(): String = lowercase(Locale.US).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalizeFirstLetter() }

fun String?.isNotNullNorEmpty(): Boolean = !isNullOrEmpty()

fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }
}

fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }
}