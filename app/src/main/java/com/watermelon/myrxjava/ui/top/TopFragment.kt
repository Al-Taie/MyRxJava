package com.watermelon.myrxjava.ui.top

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.myrxjava.databinding.FragmentTopBinding
import com.watermelon.myrxjava.ui.base.BaseFragment

class TopFragment : BaseFragment<FragmentTopBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentTopBinding
        get() = FragmentTopBinding::inflate
}