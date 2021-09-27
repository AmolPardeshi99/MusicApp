package com.example.unit4_codingeval_2.activity.adapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit4_codingeval_2.R
import com.example.unit4_codingeval_2.activity.adapter.recyclerview.PizzaAdapter
import com.example.unit4_codingeval_2.activity.adapter.recyclerview.PizzaModel
import com.example.unit4_codingeval_2.model.remote.model.Crust
import com.example.unit4_codingeval_2.model.remote.retrofit.APIService
import com.example.unit4_codingeval_2.model.remote.retrofit.ItemOnClickListener
import com.example.unit4_codingeval_2.model.remote.retrofit.Network
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(),ItemOnClickListener {

    lateinit var pizzaAdapter: PizzaAdapter
    var pizzaList= mutableListOf<PizzaModel>()
    var crustList = listOf<Crust>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callAPi()
    }

    private fun callAPi() {
        CoroutineScope(Dispatchers.IO).launch {
            val api  = Network.getRetrofit().create(APIService::class.java)
            val response = api.getAllPizzaData()


            crustList = response.crusts!!

            for (i in crustList){
                var pizzaModel : PizzaModel = PizzaModel()
                pizzaModel.desc = response?.description
                pizzaModel.name = i.name
                pizzaModel.prize = i.sizes?.get(0)?.price?.toDouble()
                pizzaList.add(pizzaModel)
            }




            CoroutineScope(Dispatchers.Main).launch {
                recyclerview.adapter = PizzaAdapter(this@MainActivity,pizzaList,this@MainActivity)
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
            }

        }
    }

    override fun onItemClicked(pizzaModel: PizzaModel) {

    }


}