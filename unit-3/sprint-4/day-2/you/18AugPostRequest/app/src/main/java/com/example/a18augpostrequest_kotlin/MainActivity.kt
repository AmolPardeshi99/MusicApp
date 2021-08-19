package com.example.a18augpostrequest_kotlin
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener{
            callApi()
        }
    }

    private fun callApi() {
        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.postData()
            .enqueue(object : retrofit2.Callback<ResponseModel>{
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                    val model = response.body()
                    tvEmail.text = model!!.data.email
                    tvCompany.text = model?.data.firstName
                }
                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Fail to load data",Toast.LENGTH_SHORT).show()
                }

            })
    }


}