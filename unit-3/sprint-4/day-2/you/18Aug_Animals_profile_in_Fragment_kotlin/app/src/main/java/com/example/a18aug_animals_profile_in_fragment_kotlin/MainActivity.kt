package com.example.a18aug_animals_profile_in_fragment_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoad.setOnClickListener{
            whenButtonClicked()
            btnLoad.visibility = View.GONE
        }

    }

    private fun whenButtonClicked() {
        var fragmentManager = supportFragmentManager
        val animalFragment = AnimalFragment()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flcontainer,animalFragment).commit()
    }


}