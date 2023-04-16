package com.example.uts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NovelAdapter (val data: List<Novel>) : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>() {

    class NovelViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val judul = row.findViewById<TextView>(R.id.judul_novel)
        val author = row.findViewById<TextView>(R.id.deskripsi)
        val image = row.findViewById<ImageView>(R.id.gambar)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return NovelViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
        holder.judul.text = data.get(position).judul
        holder.author.text = data.get(position).author
        holder.image.setImageResource(data.get(position).image)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val model = data.get(position)
            val judul = model.judul
            val genre = model.genre
            val image = model.image
            val author = model.author
            val sinopsis = model.sinopsis

            val intent = Intent(context, DetailNovel::class.java)
            intent.putExtra("Judul", judul)
            intent.putExtra("Genre", genre)
            intent.putExtra("Gambar", image)
            intent.putExtra("Author", author)
            intent.putExtra("Sinopsis", sinopsis)

            context.startActivity(intent)
        }
    }
}