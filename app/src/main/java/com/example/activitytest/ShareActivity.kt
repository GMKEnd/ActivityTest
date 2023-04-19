package com.example.activitytest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {

    private var mTitle: TextView? = null
    private var mBody: TextView? = null
    private var mShareUpdateBtn: Button? = null

    private var shareTitle = "title"
    private var shareBody = "body"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        initView()

        // 处理收到的分享内容
        val mIntent = intent
        val mAction = mIntent.action
        val mType = mIntent.type
        if (mAction == Intent.ACTION_SEND && mType != null) {
            when (mType) {
                "text/plain" -> dealText(mIntent)
                "image/" -> dealPic(mIntent)
            }
        }
    }

    private fun initView() {
        mTitle = findViewById(R.id.textTitle)
        mBody = findViewById(R.id.textBody)
        mShareUpdateBtn = findViewById(R.id.shareUpdateBtn)
        mShareUpdateBtn?.setOnClickListener {
            mTitle?.text = shareTitle
            mBody?.text = shareBody
        }
    }

    private fun dealText(intent: Intent) {
        shareTitle = intent.getStringExtra(Intent.EXTRA_TITLE).toString()
        shareBody = intent.getStringExtra(Intent.EXTRA_TEXT).toString()
    }

    private fun dealPic(intent: Intent) {
    }
}