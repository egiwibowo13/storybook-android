package com.tdsam.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tds.common_ui.databinding.DialogBottomBinding

class BottomDialogFragment : LockableBottomDialog() {

    interface BottomDialogListener {
        fun onPositiveButtonClicked(originTag: String)
    }

    companion object {
        private const val EXTRA_TITLE = "title"
        private const val EXTRA_CONTENT = "content"
        private const val EXTRA_BUTTON = "button"

        fun newInstance(title: String, content: String, buttonLabel: String): BottomDialogFragment {
            return BottomDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_TITLE, title)
                    putString(EXTRA_CONTENT, content)
                    putString(EXTRA_BUTTON, buttonLabel)
                }
            }
        }
    }

    private var listener: BottomDialogListener? = null

    private lateinit var viewBinding: DialogBottomBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BottomDialogListener)
            listener = context

        if (listener == null && parentFragment is BottomDialogListener)
            listener = parentFragment as BottomDialogListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DialogBottomBinding.inflate(inflater, container, false)

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
                listener?.onPositiveButtonClicked(tag ?: "")
                dismiss()
            }
        }
    }

    private fun assignContentToView() {
        with(viewBinding) {
            tvTitle.text = arguments?.getString(EXTRA_TITLE) ?: ""
            tvContent.text = arguments?.getString(EXTRA_CONTENT) ?: ""
            btnPositive.text = arguments?.getString(EXTRA_BUTTON) ?: ""
        }
    }

    fun setContent(content: String) {
        viewBinding.tvContent.text = content
    }

}
