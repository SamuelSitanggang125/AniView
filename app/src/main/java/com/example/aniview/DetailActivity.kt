package com.example.aniview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
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
        val animeGenre = intent.getStringExtra("ANIME_GENRE")
        val animeYear = intent.getStringExtra("ANIME_YEAR")
        val aniWebsite = intent.getStringExtra("aniWebsite")

        // Hubungkan view dengan data yang diterima
        val nameTextView: TextView = findViewById(R.id.detailAnimeName)
        val genreTextView: TextView = findViewById(R.id.detailAnimeGenre)
        val yearTextView: TextView = findViewById(R.id.detailAnimeYear)
        val descriptionTextView: TextView = findViewById(R.id.detailAnimeDescription)
        val imageView: ImageView = findViewById(R.id.detailAnimeImage)
        val websiteButton: Button = findViewById(R.id.webButton)

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

        // Set data ke TextViews dan ImageView
        nameTextView.text = animeName
        genreTextView.text = "Genre: $animeGenre"
        yearTextView.text = "Year: $animeYear"
        descriptionTextView.text = animeDescription
        imageView.setImageResource(animeImage)

        websiteButton.setOnClickListener {
            aniWebsite?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            }
        }
    }
}
