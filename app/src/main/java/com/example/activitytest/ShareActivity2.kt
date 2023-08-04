package com.example.activitytest

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class ShareActivity2 : AppCompatActivity(), Serializable {

    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private var shareBtn: Button? = null

    private var data: AGuy? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_2)

        textView1 = findViewById(R.id.share_2_textTest1)
        textView2 = findViewById(R.id.share_2_textTest2)
        shareBtn = findViewById(R.id.share_2_btn_share)
        shareBtn?.setOnClickListener {
            doShareToOtherApp()
        }

        val btn: Button = findViewById(R.id.share_2_btn)
        btn.setOnClickListener {
            updateTextView()
        }

        val intent = intent
//        val bundle = intent.extras
        data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra("serializable", AGuy::class.java)
        } else {
            intent.getBundleExtra("bundle")?.getSerializable("data") as AGuy?
        }
        Log.i("passClass", "name is:${data?.getName()}, height is:${data?.getHeight()}")

//        val bundle = intent.getBundleExtra("bundle")
//        val name = bundle?.getString("name")
//        val height = bundle?.getInt("height")
    }

    private fun updateTextView() {
        textView1?.text = data?.getName()
        textView2?.text = data?.getHeight().toString()
    }

    private fun doShareToOtherApp() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "hello world")
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "to"))
    }
}