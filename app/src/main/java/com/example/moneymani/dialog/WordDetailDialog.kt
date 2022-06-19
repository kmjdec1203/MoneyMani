//package com.example.moneymani.dialog
//
//import android.app.Dialog
//import android.content.Context
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.view.*
//import android.widget.TextView
//import androidx.databinding.Bindable
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.DialogFragment
//import com.example.moneymani.R
//import com.example.moneymani.databinding.DialogWordBinding
//import kotlinx.android.synthetic.main.activity_start.*
//import kotlinx.android.synthetic.main.dialog_word.*
//
//class WordDetailDialog(val title: String, val detail: String) : DialogFragment() {
//
//    private var _binding: DialogWordBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        _binding = DialogWordBinding.inflate(layoutInflater, fl_container, false)
//        dialog.show()
//        dialog.window?.setLayout(900, 1000)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//
//        val binding: DialogWordBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(context),
//            R.layout.dialog_word,
//            null,
//            false
//        )
//        dialog.setContentView(binding.root)
//        dialog.tv_title.text = title
//        dialog.tv_detail.text = detail
//    }
//
//}