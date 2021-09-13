package com.example.unit4_codingeval_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        setFragment1()
        setFragment2()
    }

    private fun setFragment1() {
        val fragmenttransaction = fragmentManager.beginTransaction()
        val fragment1 = AddItemFragment()
        fragmenttransaction.replace(R.id.flContainer1,fragment1).addToBackStack("add item frag").commit()
    }

    private fun setFragment2() {
        val fragmenttransaction = fragmentManager.beginTransaction()
        val fragment2 = SearchItemFragment()
        fragmenttransaction.replace(R.id.flContainer2,fragment2).addToBackStack("search fragment").commit()

    }


}