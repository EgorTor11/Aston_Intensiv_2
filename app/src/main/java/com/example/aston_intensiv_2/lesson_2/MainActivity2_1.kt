package com.example.aston_intensiv_2.lesson_2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.databinding.ActivityMain21Binding

class MainActivity2_1 : AppCompatActivity() {
    private val STR_KEY="count"
    private var mCount = 0
    lateinit var binding: ActivityMain21Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain21Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            buttonCount.setOnClickListener {
                countUp()
            }
            buttonSayHello.setOnClickListener {
                sayHello()
            }

            buttonZero.setOnClickListener{
                mCount=0
                showCount.text=mCount.toString()
                it.setBackgroundColor(Color.GRAY)
            }
        }
    }

    fun sayHello() {
       startActivity(Intent(this,SecondActivity2_1::class.java).putExtra(STR_KEY,mCount.toString()))
    }

    fun countUp() {
        mCount++
        binding.showCount.text = mCount.toString()
        if (mCount % 2 == 0) {
            binding.buttonCount.setBackgroundColor(Color.GREEN)
        }else{
            binding.buttonCount.setBackgroundColor(Color.BLUE)
        }
        binding.buttonZero.setBackgroundColor(Color.BLUE)
    }
}