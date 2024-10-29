package com.example.aniview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val animeName = intent.getStringExtra("ANIME_NAME")
        val animeDescription = intent.getStringExtra("ANIME_DESCRIPTION")
        val animeImage = intent.getIntExtra("ANIME_IMAGE", 0)

        // Hubungkan view dengan data yang diterima
        val nameTextView: TextView = findViewById(R.id.detailAnimeName)
        val descriptionTextView: TextView = findViewById(R.id.detailAnimeDescription)
        val imageView: ImageView = findViewById(R.id.detailAnimeImage)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            finish()
        }
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Set title if needed
        supportActionBar?.title = "Detail Anime"

        nameTextView.text = animeName
        descriptionTextView.text = animeDescription
        imageView.setImageResource(animeImage)
    }
}
