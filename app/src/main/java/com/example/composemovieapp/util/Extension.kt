package com.example.composemovieapp.util

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.hideKeyboard(v: View) {
    try {
        val inputMethodManager =
            this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(v.windowToken, 0)
        v.clearFocus()
    } catch (e: Exception) {
        Log.d("KeyboardError", e.message.orEmpty())
    }
}