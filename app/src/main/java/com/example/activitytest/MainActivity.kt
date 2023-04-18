package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            doDynamicIntent()
            doStaticIntent()
        }
    }

    private fun doDynamicIntent() {
        val intent = Intent()
        intent.setClass(this, ShareActivity2::class.java)
        startActivity(intent)
    }

    private fun doStaticIntent() {
        val intent = Intent("actionTest")
        startActivity(intent)
    }
}