package com.example.kotlindial

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCall.setOnClickListener({
        val perm = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE)
            if(perm == PackageManager.PERMISSION_GRANTED)
            {
                call()
            }
            else
            {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(
                        Manifest.permission.CALL_PHONE
                    ) ,
                    8700
                )
            }

        })
    }
    fun call()
    {
        val telNo = etNum.text.toString()
        val uri = Uri.parse("tel:" + telNo)
        val intent = Intent(Intent.ACTION_CALL, uri)
        startActivity(intent)
    }
}
