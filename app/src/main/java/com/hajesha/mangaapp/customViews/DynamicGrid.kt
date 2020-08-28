package com.hajesha.mangaapp.customViews

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import com.hajesha.mangaapp.R

class DynamicGrid @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : GridLayout(context, attrs) {

    private var columnWidth: Int = 0

    init {

        val a =
            getContext().obtainStyledAttributes(attrs, R.styleable.DynamicGrid)
        try {
            columnWidth = a.getDimensionPixelSize(R.styleable.DynamicGrid_columnWidth, 0)
        } finally {
            a.recycle()
        }

        columnCount = 1
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)

        val width = MeasureSpec.getSize(widthSpec)
        if ( columnWidth > 0 && width > 0){
            val screenSpace = width - paddingRight - marginRight - paddingLeft - marginLeft
            val numberOfColumns = Math.max(1, screenSpace / columnWidth)
            setColumnCount(numberOfColumns)
        }
    }
}