package com.example.ds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Corrected Python initialization
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(applicationContext))
        }
    }
}