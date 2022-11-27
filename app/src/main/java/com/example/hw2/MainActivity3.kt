package com.example.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //Tool bar
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val id :TextView = findViewById(R.id.studentID)
        val name :TextView = findViewById(R.id.studentName)
        val img:ImageView=findViewById(R.id.studentLogo)


        val loginAccount = GlobalVariable.getAccount()

        if (loginAccount != null) {
            id.text ="學號 : "+loginAccount.studentId
        }
        if (loginAccount != null) {
            name.text = "姓名 : "+loginAccount.name
        }

        when(loginAccount?.name){
            "盧俊銘"->img.setImageResource(R.drawable.logo)
            "小胖貓"->img.setImageResource(R.drawable.catlogo)
        }


    }
    // ToolBar 返回
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Toast.makeText(this, "按下左上角返回鍵", Toast.LENGTH_SHORT).show();
            finish()
        }
        return super.onOptionsItemSelected(item);

    }
}