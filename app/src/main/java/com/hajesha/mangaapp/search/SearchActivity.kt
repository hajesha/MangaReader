package com.hajesha.mangaapp.search

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.hajesha.mangaapp.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val layoutDemographics = findViewById(R.id.demographics) as LinearLayout


    }
}
