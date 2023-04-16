package com.example.uts

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class BacaAdapter {
    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.btnBaca)
    }
    fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        // Needed to call startActivity
        val context = holder.view.context

        holder.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailNovel.SEARCH_PREFIX}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }
}