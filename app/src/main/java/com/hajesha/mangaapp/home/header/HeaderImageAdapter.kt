package com.hajesha.mangaapp.home.header

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.hajesha.mangaapp.R

class HeaderImageAdapter (val context : Context): PagerAdapter(){

    var mContext : Context? = null;
    var imageIds : IntArray =intArrayOf(R.drawable.sample_title1, R.drawable.sample_title1, R.drawable.sample_title1)

    init {
        mContext = context
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageIds.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image = ImageView(mContext)
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        image.setImageResource(imageIds[position])
        container.addView(image, 0)
        return image
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }
}