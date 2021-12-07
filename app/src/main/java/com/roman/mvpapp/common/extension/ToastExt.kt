package com.roman.mvpapp.common.extension

import android.content.Context
import android.widget.Toast

fun Context.showToast(snackMessage: String, timeOut: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, snackMessage, timeOut).show()
}
