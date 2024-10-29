package com.example.aniview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Anime>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val topAppBar: MaterialToolbar = findViewById(R.id.topAppBar)
        topAppBar.title = "AniView"

        imageId = arrayOf(
            R.drawable.attack_on_titan,
            R.drawable.bleach,
            R.drawable.cowboy_bepop,
            R.drawable.death_note,
            R.drawable.demon_slayer,
            R.drawable.edens_zero,
            R.drawable.full_metal_alchemist,
            R.drawable.gangsta,
            R.drawable.hunter_hunter,
            R.drawable.inazuma_eleven,
            R.drawable.jujutsu_kaisen,
            R.drawable.k,
            R.drawable.log_horizon,
            R.drawable.boku_no_hero,
            R.drawable.naruto,
            R.drawable.one_piece,
            R.drawable.persona,
            R.drawable.steins_gate
        )


        heading = resources.getStringArray(R.array.anime_names)

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Anime>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val anime = Anime(imageId[i], heading[i])
            newArrayList.add(anime)
        }
        newRecyclerView.adapter = AnimeAdapter(this, newArrayList)
    }
}
