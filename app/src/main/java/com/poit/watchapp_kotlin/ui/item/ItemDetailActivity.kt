package com.poit.watchapp_kotlin.ui.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poit.watchapp_kotlin.databinding.ActivityItemDetailBinding
import com.squareup.picasso.Picasso

class ItemDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val style = intent.getStringExtra("style")
        val caseColor = intent.getStringExtra("caseColor")
        val description = intent.getStringExtra("description")
        val avatarUrl = intent.getStringExtra("avatarUrl")

        binding.itemDetailName.text = name
        binding.itemDetailStyle.text = style
        binding.itemDetailColor.text = caseColor
        binding.itemDetailDescription.text = description
        Picasso.get().load(avatarUrl).into(binding.itemDetailAvatar);

    }
}