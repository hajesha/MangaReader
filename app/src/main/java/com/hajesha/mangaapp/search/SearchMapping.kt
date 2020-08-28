package com.hajesha.mangaapp.search

import androidx.annotation.StringRes
import com.hajesha.mangaapp.R


public class SearchMapping {

    private var instance: SearchMapping? = null

    public fun getMappingInstance() {
        instance ?: synchronized(this) {
            instance ?: SearchMapping().also { instance = it }
        }
    }

    enum class Format(@StringRes id: Int) {
        ACTION(R.string.genre_action),
        WORLD(R.string.genre_comedy);

    }
}
