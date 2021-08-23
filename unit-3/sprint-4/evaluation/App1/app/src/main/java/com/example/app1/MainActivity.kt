package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity :ItemListener, AppCompatActivity() {
    private lateinit var resultList: List<Result>
    private var query = "hindi"
    private var isCalled = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(!isCalled) callAPi();
        btnSearch.setOnClickListener {
            callAPi()
        }
    }

    override fun onResume() {
        super.onResume()
        isCalled = true;
    }

    private fun callAPi() {

        if (isCalled){
            query = etSearchQuery.text.toString()
        }
        val apiClient  =  Network.getInstance().create(ApiClient::class.java)
        apiClient.getSong(query).enqueue(object : Callback<ResponseModel>{
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
        val songAdapter = SongAdapter(resultList,this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.adapter = songAdapter
        recyclerview.layoutManager = linearLayoutManager
    }

    override fun onitemClicked(bundle: Bundle) {
        var intent = Intent(this,MusicDetailsActivity::class.java)
        intent.run {
            putExtra("imageurl",bundle.getString("imageurl"))
            putExtra("trackname",bundle.getString("trackname"))
            putExtra("artistname",bundle.getString("artistname"))
            putExtra("collectionname",bundle.getString("collectionname"))
            putExtra("songurl",bundle.getString("songurl"))
            startActivity(intent)
        }
    }

}