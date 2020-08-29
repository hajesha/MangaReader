package com.hajesha.mangaapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hajesha.mangaapp.R

class UpdateBookListGridRecycleAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var listOfUpdateBook = listOf<UpdateBookModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UpdateBookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.updated_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfUpdateBook.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val updateBookViewHolder = holder as UpdateBookViewHolder
        updateBookViewHolder.bindView(listOfUpdateBook[position])
    }

    fun setUpdateBookList(listOfBook : List<UpdateBookModel>){
        this.listOfUpdateBook = listOfBook
        notifyDataSetChanged()
    }

}