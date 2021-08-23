package com.example.a20augnavigationgraph_you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_time_and_date.*

class TimeAndDateFragment : Fragment(R.layout.fragment_time_and_date) {
    private  lateinit var navController: NavController
    private lateinit var  description :String
    private lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromEventFrag()
    }

    private fun getDataFromEventFrag() {
        arguments?.run {
            title = getString("title").toString()
            description = getString("desc").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnNext2.setOnClickListener {
            var startDate = etStartDate.text.toString()
            var startTime = etStartTime.text.toString()
            var endDate = etEndDate.text.toString()
            var endTime = etEndTime.text.toString()

            var bundle = Bundle()
            bundle.putString("title",title)
            bundle.putString("desc",description)
            bundle.putString("startTime",startTime)
            bundle.putString("startDate",startDate)
            bundle.putString("endDate",endDate)
            bundle.putString("endTime",endTime)
            navController.navigate(R.id.action_timeAndDateFragment_to_priseDetailFragment,bundle)
        }
    }
}