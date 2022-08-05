package com.kelompok.doaseharihari

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.kelompok.doaseharihari.ui.lightStatusBar
import com.kelompok.doaseharihari.ui.setFullScreen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = Color.TRANSPARENT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btndoa: Button = findViewById(R.id.ButtonDoa)
        btndoa.setOnClickListener(this)
        val btnsurah: Button = findViewById(R.id.JuzAmma)
        btnsurah.setOnClickListener(this)
        val btninfo: Button = findViewById(R.id.Info)
        btninfo.setOnClickListener(this)

        setFullScreen(window)
        lightStatusBar(window)
        setInitLayout()
    }

    private fun setInitLayout(){
        layoutDoa.setOnClickListener {
            startActivity(Intent(this@MainActivity,DoaActivity::class.java))
        }
        layoutJuzama.setOnClickListener {
            startActivity(Intent(this@MainActivity,SurahActivity::class.java))
        }
        layoutInfo.setOnClickListener {
            startActivity(Intent(this@MainActivity,InfoActivity::class.java))
        }
//        floatsearch.setOnClickListener {
//            startActivity(Intent(this@MainActivity,Cari::class.java))
//        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id){
                R.id.ButtonDoa -> {
                    val IntentDoa = Intent(this@MainActivity,DoaActivity::class.java)
                    startActivity(IntentDoa)
                }
                R.id.JuzAmma -> {
                    val IntentJuzamma = Intent(this@MainActivity,SurahActivity::class.java)
                    startActivity(IntentJuzamma)
                }
                R.id.Info -> {
                    val IntentInfo = Intent(this@MainActivity,InfoActivity::class.java)
                    startActivity(IntentInfo)
                }
            }
        }
    }
}

