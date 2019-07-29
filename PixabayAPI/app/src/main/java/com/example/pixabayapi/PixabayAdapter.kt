package com.example.pixabayapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.ArrayList
import kotlinx.android.synthetic.main.item_row.view.*


class PixabayAdapter(val mcontext : Context, private val pixabayList : ArrayList<PixabayUser>) : RecyclerView.Adapter<PixabayAdapter.PixabayViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)  =
        PixabayViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_row,p0,false))


    override fun getItemCount() =
         pixabayList.size


    override fun onBindViewHolder(p0: PixabayViewHolder, p1: Int) {
        p0.bind(pixabayList[p1])
    }

    class PixabayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){



        fun bind(pixabayUser : PixabayUser){

            itemView.tvCreator.text = pixabayUser.user
            itemView.tvLikes.text = "Likes : " + pixabayUser.likes.toString()
            Picasso.get().load(pixabayUser.largeImageURL).fit().centerInside().into(itemView.ivImage)
        }
    }
}