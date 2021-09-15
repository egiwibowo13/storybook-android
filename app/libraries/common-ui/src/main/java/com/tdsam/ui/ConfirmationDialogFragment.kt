package com.tdsam.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.tds.common_ui.databinding.ConfirmationBottomBinding
import com.tdsam.ui.model.ConfirmationDialogParam

class ConfirmationDialogFragment : LockableBottomDialog() {

    interface ConfirmationDialogListener {
        fun onPositiveButtonClicked()
        fun onNegativeButtonClicked()
    }

    companion object {
        private const val EXTRA_PARAMS = "params"

        fun newInstance(params: ConfirmationDialogParam): ConfirmationDialogFragment {
            return ConfirmationDialogFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_PARAMS, params)
                }
            }
        }
    }

    private var listener: ConfirmationDialogListener? = null

    private lateinit var viewBinding: ConfirmationBottomBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ConfirmationDialogListener)
            listener = context

        if (listener == null && parentFragment is ConfirmationDialogListener)
            listener = parentFragment as ConfirmationDialogListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = ConfirmationBottomBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
        assignContentToView()
    }

    private fun setupListener() {
        with(viewBinding) {
            btnClose.setOnClickListener {
                dismiss()
            }

            btnPositive.setOnClickListener {
                listener?.onPositiveButtonClicked()
                dismiss()
            }

            btnNegative.setOnClickListener {
                listener?.onNegativeButtonClicked()
                dismiss()
            }
        }
    }

    private fun assignContentToView() {
        val params: ConfirmationDialogParam = arguments?.getParcelable(EXTRA_PARAMS) ?: ConfirmationDialogParam()
        with(viewBinding) {
            if (params.imageRes != null) ivLogo.setImageResource(params.imageRes) else ivLogo.isGone = true
            params.titleRes?.let { tvTitle.text = getString(it) }
            params.contentRes?.let { tvContent.text = getString(it) }
            params.positiveLabelRes?.let { btnPositive.text = getString(it) }
            params.negativeLabelRes?.let { btnNegative.text = getString(it) }
        }
    }

}
