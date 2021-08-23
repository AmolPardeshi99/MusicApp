package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var resultList: List<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSearch.setOnClickListener {
            callAPi()
        }
    }

    private fun callAPi() {
        val apiClient  =  Network.getInstance().create(ApiClient::class.java)
        apiClient.getSong(etSearchQuery.text.toString()).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
              response?.run {
                    resultList = body()?.results!!
                  setRecyclerview()

                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Data Fetching failed",Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setRecyclerview() {
        val songAdapter = SongAdapter(resultList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.adapter = songAdapter
        recyclerview.layoutManager = linearLayoutManager
    }
}