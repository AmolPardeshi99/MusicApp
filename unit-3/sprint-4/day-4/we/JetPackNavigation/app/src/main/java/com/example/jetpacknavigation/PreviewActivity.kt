package com.example.jetpacknavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getIntentData()
    }

    private fun getIntentData() {
        intent?.run {
            tvStudentName.text = getStringExtra("name")
            tvStudentAge.text = "${getIntExtra("age",0)}"
            tvStudentGrade.text = getStringExtra("grade")
            tvStudentPercentage.text = getStringExtra("percentage")
        }
    }
}