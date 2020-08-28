package com.hajesha.mangaapp.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.CompoundButton
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.hajesha.mangaapp.R

class ThreeChoiceChip(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int, @StyleRes defStyleRes: Int) : Chip(context, attrs) {

    companion object {
        const val UNKNOWN = -1
        const val DESELECTED = 0
        const val SELECTED = 1
    }

    private var state: Int = 0

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ThreeChoiceChip,
            defStyleAttr, defStyleRes
        ).apply {

            try {
                val chipDrawable =
                    ChipDrawable.createFromAttributes(context, attrs, defStyleAttr, defStyleRes)
                setChipDrawable(chipDrawable)

                state = UNKNOWN
                updateButton()

                setOnCheckedChangeListener() { compoundButton: CompoundButton, b: Boolean ->
                    when (state) {
                        UNKNOWN -> state = SELECTED
                        DESELECTED -> state = UNKNOWN
                        SELECTED -> state = DESELECTED
                    }
                    updateButton()
                }
            } finally {
                recycle()
            }
        }
    }

    fun getState(): Int {
        return state
    }

    fun setState(updatedState: Int) {
        state = updatedState
        updateButton()
    }

    private fun updateButton() {
        var color = R.color.colorUnknown
        when (state) {
            UNKNOWN -> color = R.color.colorUnknown
            DESELECTED -> color = R.color.colorDeselected
            SELECTED -> color = R.color.colorSelected
        }
        setChipBackgroundColorResource(color);
    }
}