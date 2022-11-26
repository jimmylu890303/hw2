package com.example.hw2

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Tool bar
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        //Get intent data
        val sport_name = intent.getStringExtra("sport_name")

        val posterText:TextView = findViewById(R.id.posterText)
        val posterImage:ImageView = findViewById(R.id.posterImg)
        //Set data to view
        posterText.text=sport_name;
        posterImage.setImageResource(matchImg(sport_name.toString()))

    }
    // ToolBar 返回
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Toast.makeText(this, "按下左上角返回鍵", Toast.LENGTH_SHORT).show();
            finish()
        }
        return super.onOptionsItemSelected(item);

    }
    fun matchImg(sportname:String):Int{
        var imageId:Int=0;
        when(sportname){
            "Baseball" -> imageId= R.drawable.baseball_photo
            "Basketball" -> imageId= R.drawable.basketball_photo
            "Volleyball" -> imageId= R.drawable.volleyball_photo
            "Football" ->imageId= R.drawable.football_photo
        }
        return  imageId
    }
}