package com.example.vtu_counter

import android.annotation.SuppressLint
import android.content.IntentSender.OnFinished
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var counterdisplay:TextView
    lateinit var startbutton:Button
    lateinit var stopbutton:Button
    lateinit var reset:Button

    val timer=MyCounter(1000000,1000);
    var count:Int=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterdisplay = findViewById(R.id.display)
        startbutton = findViewById(R.id.startbutton)
        stopbutton = findViewById(R.id.stopbutton)
        reset = findViewById(R.id.resetbutton)

        startbutton.setOnClickListener {
            timer.start()
            startbutton.isEnabled = false

        }
        stopbutton.setOnClickListener {
            timer.cancel()
            stopbutton.isEnabled = true
        }
        reset.setOnClickListener {
            timer.cancel()
            startbutton.isEnabled = true;
            count = 0;
            counterdisplay.text = (count).toString()
        }

    }
    inner class MyCounter(x:Long,y:Long):CountDownTimer(x,y){
        override fun onTick(millisUntilFinished: Long)
        {
            count++
            counterdisplay.text=(count).toString()
        }

        override fun onFinish() {
            counterdisplay.text="Finished"
        }

    }
}