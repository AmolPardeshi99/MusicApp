package com.example.a20augnavigationgraph_you

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_event_detail.*

class EventDetailFragment : Fragment(R.layout.fragment_event_detail) {
private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btnNext.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()

            val bundle = Bundle()
            bundle.putString("title",title)
            bundle.putString("desc",description)
            navController.navigate(R.id.action_eventDetailFragment_to_timeAndDateFragment,bundle)
        }
    }
}