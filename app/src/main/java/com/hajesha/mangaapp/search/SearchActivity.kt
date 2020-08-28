package com.hajesha.mangaapp.search

import android.os.Bundle
import android.view.Gravity
import android.view.View.TEXT_ALIGNMENT_CENTER
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import com.hajesha.mangaapp.R
import com.hajesha.mangaapp.customViews.DynamicGrid
import com.hajesha.mangaapp.customViews.ThreeChoiceChip
import kotlin.math.roundToInt


class SearchActivity : AppCompatActivity() {

    val STATUS_MAP = mutableMapOf<String, Int>()
    val DEMOGRAPHIC_MAP = mutableMapOf<String, Int>()
    val WARNING_MAP = mutableMapOf<String, Int>()
    val GENRES_MAP = mutableMapOf<String, Int>()
    val THEME_MAP = mutableMapOf<String, Int>()
    val FORMAT_MAP = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        //TODO: move all the mapping to a repo
        initializeStatusMap()
        initializeWarningMap()
        initializeDemographicMap()
        initializeGenreMap()

//        initializeSection(STATUS_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.status)
//        initializeSection(DEMOGRAPHIC_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.demographics)
//        initializeSection(WARNING_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.warnings)
        initializeSection(GENRES_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.genres)
//        initializeSection(THEME_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.theme)
//        initializeSection(FORMAT_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.format)
    }

//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//        val view =  super.onCreateView(name, context, attrs)
//        initializeSection(GENRES_MAP, R.style.Widget_MaterialComponents_Chip_Choice,R.id.genres)
//        return view
//    }

    private fun initializeStatusMap() {
        STATUS_MAP.put(getString(R.string.status_ongoing), 1)
        STATUS_MAP.put(getString(R.string.status_completed), 2)
        STATUS_MAP.put(getString(R.string.status_cancelled), 3)
        STATUS_MAP.put(getString(R.string.status_hiatus), 4)
    }

    private fun initializeDemographicMap() {
        DEMOGRAPHIC_MAP.put(getString(R.string.demographic_shounen), 1)
        DEMOGRAPHIC_MAP.put(getString(R.string.demographic_shoujo), 2)
        DEMOGRAPHIC_MAP.put(getString(R.string.demographic_seinen), 3)
        DEMOGRAPHIC_MAP.put(getString(R.string.demographic_josei), 4)
    }

    private fun initializeWarningMap() {
        WARNING_MAP.put(getString(R.string.warning_ecchi), 1)
        WARNING_MAP.put(getString(R.string.warning_gore), 2)
        WARNING_MAP.put(getString(R.string.warning_sv), 3)
        WARNING_MAP.put(getString(R.string.warning_smut), 4)
    }

    private fun initializeGenreMap() {
        GENRES_MAP.put(getString(R.string.genre_action), 2)
        GENRES_MAP.put(getString(R.string.genre_adventure), 3)
        GENRES_MAP.put(getString(R.string.genre_comedy), 4)
        GENRES_MAP.put(getString(R.string.genre_crime), 5)
        GENRES_MAP.put(getString(R.string.genre_drama), 6)
        GENRES_MAP.put(getString(R.string.genre_fantasy), 7)
        GENRES_MAP.put(getString(R.string.genre_historical), 8)
        GENRES_MAP.put(getString(R.string.genre_horror), 9)
        GENRES_MAP.put(getString(R.string.genre_isekai), 10)
        GENRES_MAP.put(getString(R.string.genre_magical), 11)
        GENRES_MAP.put(getString(R.string.genre_medical), 12)
        GENRES_MAP.put(getString(R.string.genre_mystery), 13)
        GENRES_MAP.put(getString(R.string.genre_philosophical), 14)
        GENRES_MAP.put(getString(R.string.genre_psychological), 15)
        GENRES_MAP.put(getString(R.string.genre_romance), 16)
        GENRES_MAP.put(getString(R.string.genre_scifi), 17)
        GENRES_MAP.put(getString(R.string.genre_shoujoai), 18)
        GENRES_MAP.put(getString(R.string.genre_shounenai), 19)
        GENRES_MAP.put(getString(R.string.genre_sliceoflife), 20)
        GENRES_MAP.put(getString(R.string.genre_sports), 21)
        GENRES_MAP.put(getString(R.string.genre_superhero), 22)
        GENRES_MAP.put(getString(R.string.genre_thriller), 23)
        GENRES_MAP.put(getString(R.string.genre_tragedy), 24)
        GENRES_MAP.put(getString(R.string.genre_wuxia), 25)
        GENRES_MAP.put(getString(R.string.genre_yaoi), 26)
        GENRES_MAP.put(getString(R.string.genre_yuri), 27)
    }
    private fun initializeSection(map : Map<String, Int>, @StyleRes style: Int, @IdRes chipGroupId: Int){
        val chipGroup = findViewById<DynamicGrid>(chipGroupId)
        if (chipGroup != null) {
            for (key in map.keys) {
                val chip = ThreeChoiceChip(chipGroup.context, null, 0, style)
                chip.text = key
                chipGroup.addView(chip)
            }
        }
    }
}
