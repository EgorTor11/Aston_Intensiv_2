package com.example.aston_intensiv_2.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.databinding.ActivitySecond21Binding

class SecondActivity2_1 : AppCompatActivity() {
    private val STR_KEY="count"
    lateinit var  binding:ActivitySecond21Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecond21Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCount.text=intent.getStringExtra(STR_KEY)
    }
}