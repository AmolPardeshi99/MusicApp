package com.example.unit4_codingeval_1

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.widget.addTextChangedListener
import com.example.unit4_codingeval_1.database.DatabaseHandler
import com.example.unit4_codingeval_1.recyclerview.ItemAdapter
import com.example.unit4_codingeval_1.recyclerview.ModelClass
import kotlinx.android.synthetic.main.fragment_search_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SearchItemFragment : Fragment() {

    lateinit var databaseHandler : DatabaseHandler
    lateinit var itemAdapter: ItemAdapter
    private var itemList = mutableListOf<ModelClass>()

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
        CoroutineScope(Dispatchers.Main).launch {
            etSearchQuery.addTextChangedListener(textWatcher)
        }

    }
    private val textWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var searchfactor = etSearchQuery.text
            itemList = databaseHandler.searchData(searchfactor.toString())
            setRecyclerView()
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

    private fun setRecyclerView() {
        itemAdapter = ItemAdapter(context as Activity,itemList)
        recyclerview.adapter = itemAdapter
    }

    private fun updateUI(){
        val latestdaat = databaseHandler.searchData(etSearchQuery.text.toString())
        itemList.clear()
        latestdaat.let {
            itemList.addAll(it)
        }
        itemAdapter.notifyDataSetChanged()
    }

}