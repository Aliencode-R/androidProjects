package com.example.nexttry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isAdd  = false
    var isDiv = false
    var isMul = false
    var isSub = false
    var val1 = 0.0
    var val2 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener{
            val1 = etScreen.text.toString().toDouble()
            etScreen.text = null
            isAdd = true
        }
        btnSub.setOnClickListener{
            val1 = etScreen.text.toString().toDouble()
            etScreen.text = null
            isSub = true
        }
        btnMul.setOnClickListener{
            val1 = etScreen.text.toString().toDouble()
            etScreen.text = null
            isMul = true
        }
        btnDiv.setOnClickListener{
            val1 = etScreen.text.toString().toDouble()
            etScreen.text = null
            isDiv = true
        }
        btnClear.setOnClickListener{
            if(etScreen.text.toString().length > 1)
            {
                val n = etScreen.text.toString()
                etScreen.setText(n.substring(0,n.length-1))
            }
            else
            {
                etScreen.text = null
            }
        }
        btnEqual.setOnClickListener{
            val2 = etScreen.text.toString().toDouble()
            etScreen.text = null
            if(isAdd)
            {
                etScreen.setText((val1 + val2).toString())
                isAdd = false
            }
            else if(isSub)
            {
                etScreen.setText((val1 - val2).toString())
                isSub = false
            }
            else if(isMul)
            {
                etScreen.setText((val1 * val2).toString())
                isMul = false
            }
            else if(isDiv)
            {
                etScreen.setText((val1 / val2).toString())
                isDiv = false
            }
        }
        btn0.setOnClickListener{
            val s = etScreen.text.toString() + '0'
            etScreen.setText(s)
        }
        btn1.setOnClickListener{
            val s = etScreen.text.toString() + "1"
            etScreen.setText(s)
        }
        btn2.setOnClickListener{
            val s = etScreen.text.toString() + '2'
            etScreen.setText(s)
        }
        btn3.setOnClickListener{
            val s = etScreen.text.toString() + '3'
            etScreen.setText(s)
        }
        btn4.setOnClickListener{
            val s = etScreen.text.toString() + '4'
            etScreen.setText(s)
        }
        btn5.setOnClickListener{
            val s = etScreen.text.toString() + '5'
            etScreen.setText(s)
        }
        btn6.setOnClickListener{
            val s = etScreen.text.toString() + '6'
            etScreen.setText(s)
        }
        btn7.setOnClickListener{
            val s = etScreen.text.toString() + '7'
            etScreen.setText(s)
        }
        btn8.setOnClickListener{
            val s = etScreen.text.toString() + '8'
            etScreen.setText(s)
        }
        btn9.setOnClickListener{
            val s = etScreen.text.toString() + '9'
            etScreen.setText(s)
        }

    }
}
