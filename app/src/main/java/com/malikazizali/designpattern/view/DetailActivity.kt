package com.malikazizali.designpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.malikazizali.designpattern.R
import com.malikazizali.designpattern.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val img = intent.getStringExtra("img")
        val nama = intent.getStringExtra("nama")
        val cat = intent.getStringExtra("cat")
        val price = intent.getStringExtra("price")

        Glide.with(this).load(img).into(binding.carImage)
        binding.tvId.text = id
        binding.tvName.text = nama
        binding.tvCategory.text = cat
        binding.tvPrice.text = price
    }
}