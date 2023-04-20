package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
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
        val btn4: Button = findViewById(R.id.main_btn4)
        btn4.setOnClickListener {
            doPassClass()
        }
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

    private fun doPassClass() {
        // 被传递的类需要实现 Serializable后通过bundle传递
        val data = AGuy()
        data.setName("aaa")
        data.setHeight(199)
        Log.e("passClass", "name is:${data.getName()}, height is:${data.getHeight()}")
        val bundle = Bundle()
        bundle.putSerializable("data", data)

        val intent = Intent()
        if (Build.VERSION.SDK_INT >= 33) {
            intent.putExtra("serializable", data)
        } else {
            intent.putExtra("bundle", bundle)
        }
        intent.setClass(this, ShareActivity2::class.java)
        startActivity(intent)
    }
}