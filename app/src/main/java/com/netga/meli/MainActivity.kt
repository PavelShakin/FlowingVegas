package com.netga.meli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netga.meli.presenter.StartActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, StartActivity::class.java))
    }
}