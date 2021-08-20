package com.example.jetpacknavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_student_performance_detail.*

class StudentPerformanceDetail : Fragment(R.layout.fragment_student_performance_detail) {
    private lateinit var name: String
    private var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        arguments?.run {
            name = getString("name")!!
            age = getInt("age")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPreview.setOnClickListener {
            val percentage = etStudentPercentage.text.toString()
            val grade = etStudentGrade.text.toString()

            val intent = Intent(context, PreviewActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("percentage", percentage)
            intent.putExtra("grade", grade)
            startActivity(intent)
        }
    }
}