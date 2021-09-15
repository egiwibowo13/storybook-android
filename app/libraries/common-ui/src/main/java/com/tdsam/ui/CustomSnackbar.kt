package com.tdsam.ui

import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.tds.common_ui.R

fun Snackbar.showAsError() {
    view.background = ContextCompat.getDrawable(context, R.drawable.bg_snackbar_error)
    show()
}

fun Snackbar.showAsSuccess() {
    view.background = ContextCompat.getDrawable(context, R.drawable.bg_snackbar_success)
    show()
}
