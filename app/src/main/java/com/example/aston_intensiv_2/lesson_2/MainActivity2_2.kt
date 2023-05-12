package com.example.aston_intensiv_2.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.databinding.ActivityMain22Binding

class MainActivity2_2 : AppCompatActivity() {
    lateinit var binding: ActivityMain22Binding
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            mCount= savedInstanceState.getInt("keyInt")
        }
        binding = ActivityMain22Binding.inflate(layoutInflater)
        setContentView(binding.root)
        countUp()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("keyInstance", binding.tvCount.text.toString())
        outState.putInt("keyInt", mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.tvCount.text = savedInstanceState.getString("keyInstance")
    }

    private fun countUp() = with(binding){
        buttonCount.setOnClickListener {
            mCount++
            tvCount.text = mCount.toString()
        }
    }
}