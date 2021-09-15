package com.tdsam.ui

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class LockableBottomDialog : BottomSheetDialogFragment() {

    override fun setCancelable(cancelable: Boolean) {
        super.setCancelable(cancelable)

        (dialog as? BottomSheetDialog)?.window?.decorView?.let {
            val bottomSheetView: View = it.findViewById(com.google.android.material.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheetView).isHideable = cancelable
        }
    }
}
