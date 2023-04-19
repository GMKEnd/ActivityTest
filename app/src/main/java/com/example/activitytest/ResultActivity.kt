package com.example.activitytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        intent.putExtra("result_data", "22222")
        setResult(RESULT_OK, intent)
        finish()
    }
}