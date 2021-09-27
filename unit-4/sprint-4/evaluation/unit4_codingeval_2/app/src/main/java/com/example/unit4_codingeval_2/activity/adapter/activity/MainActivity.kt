package com.example.unit4_codingeval_2.activity.adapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unit4_codingeval_2.R
import com.example.unit4_codingeval_2.activity.adapter.recyclerview.PizzaAdapter
import com.example.unit4_codingeval_2.activity.adapter.recyclerview.PizzaModel



class MainActivity : AppCompatActivity() {

    lateinit var pizzaAdapter: PizzaAdapter
    lateinit var pizzaList: MutableList<PizzaModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}