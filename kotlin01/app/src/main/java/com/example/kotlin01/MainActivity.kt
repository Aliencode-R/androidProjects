package com.example.kotlin01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener({
            val result = etVal1.text.toString().toInt() + etVal2.text.toString().toInt()
            tvResult.text = result.toString()
        })
    }
}
