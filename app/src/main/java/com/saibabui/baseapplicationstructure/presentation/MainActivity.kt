package com.saibabui.baseapplicationstructure.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saibabui.baseapplicationstructure.R
import com.saibabui.baseapplicationstructure.data.remote.dto.DemoInterface
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : AppCompatActivity(), DemoInterface {
    override var TAG: String = ""
        get() = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}