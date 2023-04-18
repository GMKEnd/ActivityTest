package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        intent.putExtra("extra_ff", true)
        setResult(RESULT_OK, intent)
        finish()
    }
}