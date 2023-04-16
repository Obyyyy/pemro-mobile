package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class DetailNovel : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q=baca+novel+"
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informasi_item)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val judulNovel = findViewById<TextView>(R.id.judul_novel)
        val namaAuthor = findViewById<TextView>(R.id.nama_author)
        val coverNovel = findViewById<ImageView>(R.id.coverNovel)
        val genres = findViewById<TextView>(R.id.genres)
        val sinops = findViewById<TextView>(R.id.sinops)
        val button = findViewById<Button>(R.id.btnBaca)

        var intent = intent
        val judul = intent.getStringExtra("Judul")
        val genre = intent.getStringExtra("Genre")
        val gambar = intent.getIntExtra("Gambar", 0)
        val author = intent.getStringExtra("Author")
        val sinopsis = intent.getStringExtra("Sinopsis")

        actionBar.setTitle(judul)
        judulNovel.text = judul
        namaAuthor.text = author
        genres.text = genre
        sinops.text = sinopsis
        coverNovel.setImageResource(gambar)

        button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailNovel.SEARCH_PREFIX}${judul}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
    }
}