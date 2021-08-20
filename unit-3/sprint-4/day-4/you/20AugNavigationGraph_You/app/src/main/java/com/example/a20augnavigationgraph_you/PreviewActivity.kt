package com.example.a20augnavigationgraph_you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getData()
    }

    private fun getData() {
        intent?.run {
            tvTitle.text = getStringExtra("title")
            tvDescription.text = getStringExtra("description")
            tvEndDate.text = getStringExtra("endDate")
            tvEndTime.text = getStringExtra("endTime")
            tvPrise.text = getStringExtra("prise")
            tvCurrency.text = getStringExtra("currency")
            tvStartDate.text = getStringExtra("startDate")
            tvStartTime.text = getStringExtra("startTime")
        }
    }
}