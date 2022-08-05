package com.kelompok.doaseharihari

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok.doaseharihari.ui.lightStatusBar
import com.kelompok.doaseharihari.ui.setFullScreen
import kotlinx.android.synthetic.main.activity_surah.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class SurahActivity : AppCompatActivity() {

    var adapterSurah: AdapterSurah? = null
    var modelSurah: MutableList<ModelSurah> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = Color.TRANSPARENT
        setFullScreen(window)
        lightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah)
        rvListSurah.setLayoutManager(LinearLayoutManager(this))
        rvListSurah.setHasFixedSize(true)
        getSurah()

    }
    private fun getSurah() {
        try {
            val stream = assets.open("surah.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val strResponse = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject = JSONObject(strResponse)
                val jsonArray = jsonObject.getJSONArray("data")
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataModel = ModelSurah()
                    dataModel.strId = jsonObjectData.getString("id")
                    dataModel.strTitle = jsonObjectData.getString("title")
                    dataModel.strArabic = jsonObjectData.getString("arabic")
                    dataModel.strLatin = jsonObjectData.getString("latin")
                    dataModel.strTranslation = jsonObjectData.getString("translation")
                    modelSurah.add(dataModel)
                }
                adapterSurah = AdapterSurah(modelSurah)
                rvListSurah.adapter = adapterSurah
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        } catch (ignored: IOException) {
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }
}