package com.example.activitytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class ShareActivity2 : AppCompatActivity(), Serializable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_2)

        val intent = intent
//        val bundle = intent.extras
        val bundle = intent.getBundleExtra("Bundle")
        val name = bundle?.getString("name")
        val height = bundle?.getInt("height")

        passOn()
    }

    private fun passOn() {
    }
}