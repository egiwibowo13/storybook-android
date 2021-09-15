package com.tdsam.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.tds.common_ui.R

class SimpleLoadingDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_simple_loading)

        setCancelable(false)
        setCanceledOnTouchOutside(false)
    }
}
