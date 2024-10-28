package com.example.aniview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class AnimeAdapter(private val context: Context, private val animeList: ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_anime, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = animeList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = animeList[position]
        holder.animeImage.setImageResource(currentItem.animeImage)
        holder.tvHeading.text = currentItem.heading

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ANIME_NAME", currentItem.heading)
            intent.putExtra("ANIME_DESCRIPTION", context.resources.getStringArray(R.array.anime_descriptions)[position])
            intent.putExtra("ANIME_IMAGE", currentItem.animeImage)
            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animeImage: ShapeableImageView = itemView.findViewById(R.id.anime_image)
        val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    }
}
