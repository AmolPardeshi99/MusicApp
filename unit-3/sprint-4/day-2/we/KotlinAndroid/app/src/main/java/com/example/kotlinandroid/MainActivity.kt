package com.example.kotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
private  var list = listOf<ResponseDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFetch.setOnClickListener{
            callAPI()
        }
    }

    private fun callAPI() {

        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getPosts(etEnterId.text.toString().toInt())
            .enqueue(object : retrofit2.Callback<List<ResponseDTO>>{
                override fun onResponse(
                    call: Call<List<ResponseDTO>>,
                    response: Response<List<ResponseDTO>>
                ) {
                    list = response.body()!!
                    setRecyclerview()
                }

                override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }


    private fun setRecyclerview(){
        val postAdapter = PostAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.adapter = postAdapter
        recyclerview.layoutManager = linearLayoutManager
    }
}