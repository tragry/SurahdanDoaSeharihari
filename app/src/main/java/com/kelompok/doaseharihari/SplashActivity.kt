package com.kelompok.doaseharihari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.graphics.Color
import com.kelompok.doaseharihari.ui.lightStatusBar
import com.kelompok.doaseharihari.ui.setFullScreen

class SplashActivity : AppCompatActivity() {


    private val SPLASH_TIME_OUT:Long = 3000 // delay 3 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.TRANSPARENT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
        setFullScreen(window)
        lightStatusBar(window)
    }
}