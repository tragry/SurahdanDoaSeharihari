package com.kelompok.doaseharihari

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok.doaseharihari.ui.lightStatusBar
import com.kelompok.doaseharihari.ui.setFullScreen

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        window.statusBarColor = Color.TRANSPARENT
        setFullScreen(window)
        lightStatusBar(window)
    }
}