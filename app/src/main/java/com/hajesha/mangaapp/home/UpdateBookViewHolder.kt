package com.hajesha.mangaapp.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.updated_item.view.*

class UpdateBookViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(bookModel : UpdateBookModel){
        itemView.update_chapter.text = bookModel.numberOfUpdatedChapter.toString()
        itemView.update_title.text = bookModel.bookTitle
        Glide.with(itemView.context).load(bookModel.image).into(itemView.updated_image)
        itemView.updated_image.clipToOutline = true
    }
}
