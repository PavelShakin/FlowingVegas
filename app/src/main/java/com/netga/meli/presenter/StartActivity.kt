package com.netga.meli.presenter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.netga.meli.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btn1.setOnClickListener {
                startActivity(Intent(this@StartActivity, ProgressActivity::class.java))
            }

            btn2.setOnClickListener {
                finish()
            }
        }
    }
}