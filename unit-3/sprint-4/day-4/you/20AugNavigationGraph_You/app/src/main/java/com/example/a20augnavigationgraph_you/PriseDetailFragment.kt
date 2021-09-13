package com.example.a20augnavigationgraph_you

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_prise_detail.*

class PriseDetailFragment : Fragment(R.layout.fragment_prise_detail) {

    private lateinit var title: String
    private lateinit var description: String
    private lateinit var startDate : String
    private lateinit var startTime : String
    private lateinit var endDate : String
    private lateinit var endTime : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromTimeFrag()
    }

    private fun getDataFromTimeFrag() {
        arguments?.run {
            title = getString("title").toString()
            description = getString("desc").toString()
            startDate = getString("startDate").toString()
            startTime  = getString("startTime").toString()
            endDate = getString("endDate").toString()
            endTime = getString("endTime").toString()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPreview.setOnClickListener {

            it.run {
                var intent = Intent(context, PreviewActivity::class.java)
                var currency = etCurrency.text.toString()
                var prise = etPrise.text.toString()


                intent.run {
                putExtra("title", title)
                putExtra("description", description)
                putExtra("startDate", startDate)
                putExtra("endDate", endDate)
                putExtra("startTime", startTime)
                putExtra("endTime", endTime)
                putExtra("currency", currency)
                putExtra("prise", prise)
                startActivity(intent)

                }
            }
        }
    }
}