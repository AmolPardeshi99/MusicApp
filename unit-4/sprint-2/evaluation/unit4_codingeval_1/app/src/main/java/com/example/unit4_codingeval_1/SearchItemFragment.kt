package com.example.unit4_codingeval_1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.unit4_codingeval_1.database.DatabaseHandler
import kotlinx.android.synthetic.main.fragment_search_item.*

class SearchItemFragment : Fragment() {

    lateinit var databaseHandler : DatabaseHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        databaseHandler = DatabaseHandler(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}