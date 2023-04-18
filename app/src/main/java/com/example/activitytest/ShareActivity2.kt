package com.example.activitytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShareActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_2)

        val intent = intent
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val height = bundle?.getInt("height")
    }
}