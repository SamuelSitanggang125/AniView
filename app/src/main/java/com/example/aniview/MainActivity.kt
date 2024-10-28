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
            R.drawable.full_metal_alchemist,
            R.drawable.attack_on_titan,
            R.drawable.death_note,
            R.drawable.naruto,
            R.drawable.one_piece,
            R.drawable.steins_gate,
            R.drawable.boku_no_hero,
            R.drawable.hunter_hunter,
            R.drawable.cowboy_bepop,
            R.drawable.demon_slayer
        )

        heading = arrayOf(
            "Full Metal Alchemist",
            "Attack on Titan",
            "Death Note",
            "Naruto",
            "One Piece",
            "Steins;Gate",
            "Boku no Hero Academia",
            "Hunter×Hunter",
            "Cowboy Bepop",
            "Demon Slayer"
        )

        newRecyclerView =findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<Anime>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){

            val anime = Anime(imageId[i],heading[i])
            newArrayList.add(anime)
        }
        newRecyclerView.adapter = AnimeAdapter(this, newArrayList)

    }
}