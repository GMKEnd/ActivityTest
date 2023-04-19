package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn1: Button = findViewById(R.id.main_btn1)
        btn1.setOnClickListener {
            doDynamicIntent()
        }
        val btn2: Button = findViewById(R.id.main_btn2)
        btn2.setOnClickListener {
            doStaticIntent()
        }
        val btn3: Button = findViewById(R.id.main_btn3)
        btn3.setOnClickListener {
            doResultIntent()
        }
        textView = findViewById(R.id.main_text)
    }

    // 显式intent，通常应用在自己程序中
    private fun doDynamicIntent() {
        val intent = Intent()
        intent.setClass(this, ShareActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra("dataTest", "hello world")
        startActivity(intent)
    }

    // 隐式intent，筛选出可响应此intent(action, category, data)的组件
    private fun doStaticIntent() {
        val intent = Intent("actionTest")
        val bundle = Bundle()
        bundle.putString("name", "Garel")
        bundle.putInt("height", 170)
//        intent.putExtras(bundle)
        intent.putExtra("bundle", bundle)
        startActivity(intent)
    }

    // 在Activity结束时收到回传的intent，需要重写onActivityResult
    private fun doResultIntent() {
        val intent = Intent()
        intent.setClass(this, ResultActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == RESULT_OK) {
                    textView?.text = data?.getStringExtra("result_data")
                }
            }
        }
    }
}