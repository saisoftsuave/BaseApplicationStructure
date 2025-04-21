package com.playdate.child.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.viewbinding.ViewBinding

import com.saibabui.baseapplicationstructure.presentation.MainActivity

abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {

    protected abstract fun getViewBinding(): VBinding
    private var _binding: VBinding? = null

    val binding by lazy { _binding!! }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    fun getParentActivity(): MainActivity? {
        return activity as? MainActivity
    }

}
