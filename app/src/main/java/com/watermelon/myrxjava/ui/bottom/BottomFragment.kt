package com.watermelon.myrxjava.ui.bottom

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.myrxjava.databinding.FragmentBottomBinding
import com.watermelon.myrxjava.ui.base.BaseFragment
import com.watermelon.myrxjava.util.Constant


class BottomFragment : BaseFragment<FragmentBottomBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBottomBinding
        get() = FragmentBottomBinding::inflate
}