package com.example.repoinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = DataBindingUtil.setContentView(
//            this,
//            R.layout.activity_main
//        )
    }
}
