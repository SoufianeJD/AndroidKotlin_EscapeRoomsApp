package com.example.SoufianeJD_EscapeRoomsKotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val imgviewlist = findViewById(R.id.imglist) as ImageView
        val imgviewadd = findViewById(R.id.imgadd) as ImageView

        imgviewlist.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        imgviewadd.setOnClickListener {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}