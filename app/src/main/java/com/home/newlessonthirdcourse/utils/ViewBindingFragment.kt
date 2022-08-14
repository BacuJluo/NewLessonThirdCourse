package com.home.newlessonthirdcourse.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment

/** Создание ViewBinding для фрагментов */
abstract class ViewBindingFragment<vb : ViewBinding>(
    private var inflateBinding: (inflater: LayoutInflater, root: ViewGroup?, attachToRoot: Boolean) -> vb
) : MvpAppCompatFragment() {

    private var _binding: vb? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateBinding.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
