package com.example.scopingfunction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {
    private lateinit var responseDTO: ResponseDTO
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFetchData.setOnClickListener{
            callAPi()
        }
    }

    private fun callAPi() {
        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getUserDetails(2).enqueue(object : Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {
                    responseDTO = this
//                    tvName.text = responseDTO.data?.firstName
//                    tvLastName.text = responseDTO.data?.lastName
                    responseDTO.data?.apply {
                        tvName.text = firstName
                        tvLastName.text = lastName
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}