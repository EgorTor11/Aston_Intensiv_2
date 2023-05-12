package com.example.aston_intensiv_2.lesson_2

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import com.example.aston_intensiv_2.R
import com.example.aston_intensiv_2.databinding.ActivityMain23Binding

class MainActivity2_3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain23Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain23Binding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding) {

        btnWebsite.setOnClickListener {
            val url = edWebsite.text.toString()
            val webpage = Uri.parse(url)
            val intent = Intent(
                Intent.ACTION_VIEW,webpage)
            startActivity(intent)
            if (intent.resolveActivity(packageManager) != null && edWebsite.text.isNotEmpty()) {
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity2_3, R.string.alarm_put_street, Toast.LENGTH_SHORT)
                    .show()

            }
        }

        btnLocation.setOnClickListener {
            var loc = edLocation.text.toString()
            var adressUri = Uri.parse("geo:0,0?q=" + loc)
            val intent = Intent(Intent.ACTION_VIEW, adressUri)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity2_3, R.string.alarm_put_street, Toast.LENGTH_SHORT)
                    .show()
            }
        }

        btnShare.setOnClickListener {
            val edShareText = edShare.text.toString()
            val shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, edShareText)
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        }

        btnTakePicture.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            val bmp = data?.extras?.get("data") as Bitmap
            binding.imRes.setImageBitmap(bmp)

        }
    }
}