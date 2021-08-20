package com.example.a18augpostrequest_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvTitle.text = intent.getStringExtra("title")
        tvPassword.text = intent.getStringExtra("password")
        tvEmail.text = intent.getStringExtra("email")
        tvRequestType.text = intent.getStringExtra("requestType")
    }
}