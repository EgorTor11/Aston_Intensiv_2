package com.example.aston_intensiv_2.lesson_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.databinding.ActivityMain12Binding


class MainActivity1_2 : AppCompatActivity() {
    private var mCount = 0
    lateinit var binding: ActivityMain12Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain12Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            buttonCount.setOnClickListener {
                countUp()
            }
            buttonSayHello.setOnClickListener {
                showToast()
            }

            buttonZero.setOnClickListener{
                showCount.text=getString(R.string.zero)
                it.setBackgroundColor(Color.GRAY)
            }
        }
    }

    fun showToast() {
        val toast: Toast = Toast.makeText(
            this, getText(R.string.toast_message),
            Toast.LENGTH_SHORT
        )
        toast.show()
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