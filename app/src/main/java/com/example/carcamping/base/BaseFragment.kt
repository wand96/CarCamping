package com.example.carcamping.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

class BaseFragment<B : ViewDataBinding>(@LayoutRes private val layoutId: Int) :
    Fragment() {

        protected lateinit var binding: B

        protected val baseActivity: BaseActivity<*>?
            get() = activity as BaseActivity<*>?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}