package com.example.nierdatabasekotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val charList: ArrayList<Characters>) :
    RecyclerView.Adapter<Adapter.MyHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_card,
                                            parent, false)
        return MyHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.nameChar.text = charList[position].nameChar
        holder.descChar.text = charList[position].descChar
    }

    override fun getItemCount(): Int {
        return charList.size
    }
    class MyHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val nameChar: TextView = itemView.findViewById(R.id.name_chars_text)
        val descChar: TextView = itemView.findViewById(R.id.description_text)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}