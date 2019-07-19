package com.example.kotlintodolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener({
            val result = etVal1.text.toString().toInt() + etVal2.text.toString().toInt()
            val intent = Intent(this@MainActivity, secondActivity::class.java)
            intent.putExtra("result",result)
            startActivity(intent)
        })
    }
}
