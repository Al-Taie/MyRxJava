package com.watermelon.myrxjava.ui

import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.watermelon.myrxjava.R
import com.watermelon.myrxjava.databinding.ActivityMainBinding
import com.watermelon.myrxjava.ui.base.BaseActivity
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MyRxJava

    override fun setup() {}

    override fun onStart() {
        super.onStart()
        textObserve()
    }

    override fun callBack() {}

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private fun setBottomText(text: String?) {
        supportFragmentManager.findFragmentById(R.id.fragment_bottom)?.apply {
            view?.findViewById<MaterialTextView>(R.id.text_view)?.text = text
        }
    }

    private fun textObserve() {
        supportFragmentManager.findFragmentById(R.id.fragment_top)?.apply {
            view?.findViewById<TextInputEditText>(R.id.text_field)?.apply {

                Observable.create<String> { emitter ->
                    doOnTextChanged { text, _, _, _ ->
                        emitter.onNext(text.toString())
                    }
                }.debounce(1500, TimeUnit.MILLISECONDS).publish().apply {
                    connect()
                }.subscribe(
                    { text -> setBottomText(text) },
                    { e -> }
                )
            }
        }
    }
}