package com.hajesha.mangaapp.search

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.hajesha.mangaapp.R


class SearchActivity : AppCompatActivity() {

    val STATUS_MAP = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        intializeStatusMap()

        initalizeSection(STATUS_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.demographics)

    }

    private fun intializeStatusMap() {
        STATUS_MAP.put(getString(R.string.status_ongoing), 1)
        STATUS_MAP.put(getString(R.string.status_completed), 2)
        STATUS_MAP.put(getString(R.string.status_cancelled), 3)
        STATUS_MAP.put(getString(R.string.status_hiatus), 4)
    }

    private fun initalizeSection(map : Map<String, Int>, @StyleRes style: Int, @IdRes chipGroup: Int){

        //TODO: currently only two states are supported
        //maybe consider creating custom view and extending chip
        val chipGroup = findViewById<ChipGroup>(chipGroup)
        for(key in map.keys) {
            val chip = Chip(chipGroup.context)
            val chipDrawable = ChipDrawable.createFromAttributes(this@SearchActivity, null, 0, style)
            chip.setChipDrawable(chipDrawable)
            chip.text = key
            chip.setChipBackgroundColorResource(R.color.search_bubble_state)
            chipGroup.addView(chip)
        }
    }


}
