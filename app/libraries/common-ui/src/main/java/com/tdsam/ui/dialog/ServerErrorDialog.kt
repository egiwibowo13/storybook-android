package com.tdsam.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tds.common_ui.databinding.DialogServerErrorBinding
import com.tdsam.ui.LockableBottomDialog
import com.tdsam.ui.dialog.NoConnectionDialog.NoConnectionActionListener

class ServerErrorDialog : LockableBottomDialog() {

    companion object {
        @JvmStatic
        fun newInstance() = ServerErrorDialog()
    }

    private var listener: NoConnectionActionListener? = null

    private lateinit var viewBinding: DialogServerErrorBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        when {
            parentFragment is NoConnectionActionListener -> listener = parentFragment as NoConnectionActionListener
            context is NoConnectionActionListener -> listener = context
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DialogServerErrorBinding.inflate(inflater, container, false)

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

            btnRetry.setOnClickListener {
                listener?.reloadPage()
                dismiss()
            }
        }
    }
}
