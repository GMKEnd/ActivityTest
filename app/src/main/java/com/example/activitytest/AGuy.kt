package com.example.activitytest

import android.util.Log
import java.io.Serializable

class AGuy : Serializable {
    private var name = ""
    private var height = -1

    private var er = 2

    fun setName(string: String) {
        name = string
    }

    fun setHeight(int: Int) {
        height = int
    }

    fun getName(): String {
        return name
    }

    fun getHeight(): Int {
        return height
    }

    fun doSth() {
        Test01().tryTry()
    }
}

class Test01 {
    private val er = 1
    fun tryTry() {
        Log.e("see", "this is:${this.er}")
    }
}