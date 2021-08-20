package com.example.kotlin_scoping_functions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_user_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {
    private lateinit var Userlist: List<Data>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApi()
    }

    private fun callApi() {
        var apiService  = Network.getInstance().create(ApiService::class.java)
        apiService.getUserDetails(2).enqueue(object : Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {
                    Userlist = data!!
                    setRecyclerview()
                }
            }
            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setRecyclerview() {
        var linearLayoutManager = LinearLayoutManager(context)
        var adapter = UserAdapter(Userlist)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = linearLayoutManager
    }


}