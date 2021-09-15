package com.tdsam.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tds.common_ui.databinding.DialogNoConnectionBinding
import com.tdsam.ui.LockableBottomDialog

class NoConnectionDialog : LockableBottomDialog() {

    companion object {
        @JvmStatic
        fun newInstance() = NoConnectionDialog()
    }

    interface NoConnectionActionListener {
        fun openDeviceSettings()
        fun reloadPage()
    }

    private var listener: NoConnectionActionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        when {
            parentFragment is NoConnectionActionListener -> listener = parentFragment as NoConnectionActionListener
            context is NoConnectionActionListener -> listener = context
        }
    }

    private lateinit var viewBinding: DialogNoConnectionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DialogNoConnectionBinding.inflate(inflater)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        with(viewBinding) {
            btnClose.setOnClickListener {
                dismiss()
            }
            btnReloadPage.setOnClickListener {
                listener?.reloadPage()
                dismiss()
            }
            btnSetting.setOnClickListener {
                listener?.openDeviceSettings()
                dismiss()
            }
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

}
