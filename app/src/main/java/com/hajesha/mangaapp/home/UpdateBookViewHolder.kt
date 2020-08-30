package com.hajesha.mangaapp.home

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import kotlinx.android.synthetic.main.updated_item.view.*
import com.bumptech.glide.request.transition.Transition

class UpdateBookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(bookModel : UpdateBookModel){
        itemView.update_chapter.text = bookModel.numberOfUpdatedChapter.toString()
        itemView.update_title.text = bookModel.bookTitle
        Glide.with(itemView.context).load(bookModel.image).into(object : CustomTarget<Drawable>() {
            override fun onLoadCleared(placeholder: Drawable?) {}

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                itemView.updated_image.background = resource
            }
        })
    }
}
