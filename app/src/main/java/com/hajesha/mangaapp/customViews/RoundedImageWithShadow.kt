package com.hajesha.mangaapp.customViews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import android.graphics.Paint.FILTER_BITMAP_FLAG
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.TypedValue
import android.util.DisplayMetrics
import android.graphics.Bitmap
import android.view.View
import android.view.ViewOutlineProvider


class RoundedImageWithShadow @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs) {

    private var CORNER_RADIUS = 125f

    private var paint: Paint
    private var maskPaint: Paint
    private var cornerRadius: Float

    var metrics: DisplayMetrics? = null

    init {
        metrics = context.resources.displayMetrics
        cornerRadius =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, CORNER_RADIUS, metrics)

        paint = Paint(ANTI_ALIAS_FLAG)

        maskPaint = Paint(ANTI_ALIAS_FLAG or FILTER_BITMAP_FLAG)
        maskPaint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.CLEAR))

        setWillNotDraw(false)
    }

    override fun draw(canvas: Canvas) {
        cornerRadius = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            width * 0.2f, metrics
        )
        setOutlineProvider(CustomOutline(width, height, cornerRadius))
        val offscreenBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val offscreenCanvas = Canvas(offscreenBitmap)
        super.draw(offscreenCanvas)
        offscreenCanvas.drawBitmap(createMask(width, height), 0f, 0f, maskPaint)
        canvas.drawBitmap(offscreenBitmap, 0f, 0f, paint)
    }

    private class CustomOutline constructor(var width: Int, var height: Int, var radius: Float) :
        ViewOutlineProvider() {

        override fun getOutline(view: View?, outline: Outline?) {
            outline?.setRoundRect(0, 0, width, height, radius)
        }
    }

    private fun createMask(width: Int, height: Int): Bitmap {
        val mask = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8)
        val canvas = Canvas(mask)

        val paint = Paint(ANTI_ALIAS_FLAG)
        paint.setColor(Color.WHITE)

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.CLEAR))
        canvas.drawRoundRect(
            RectF(0f, 0f, width.toFloat(), height.toFloat()),
            cornerRadius,
            cornerRadius,
            paint
        )
        return mask
    }
}
