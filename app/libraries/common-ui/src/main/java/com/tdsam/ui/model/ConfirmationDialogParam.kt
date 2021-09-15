package com.tdsam.ui.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfirmationDialogParam(
    @StringRes val titleRes: Int? = null,
    @StringRes val contentRes: Int? = null,
    @DrawableRes val imageRes: Int? = null,
    @StringRes val positiveLabelRes: Int? = null,
    @StringRes val negativeLabelRes: Int? = null
) : Parcelable
