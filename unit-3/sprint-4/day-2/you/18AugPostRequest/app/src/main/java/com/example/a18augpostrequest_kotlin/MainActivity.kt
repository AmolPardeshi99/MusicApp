package com.example.a18augpostrequest_kotlin
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responseModel: ResponseModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener{
            progressbar.visibility = View.VISIBLE
            callApi()
        }
    }

    private fun callApi() {
        val apiService = Network.getInstance().create(ApiService::class.java)
        val requestType = etRequestType.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val title = etTitle.text.toString()
        val requestModel : RequestModel = RequestModel(email,password,requestType,title)
        apiService.postData(requestModel).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                response.body()?.run {
                    progressbar.visibility = View.GONE
                    Toast.makeText(applicationContext,"Data posted on Server",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity,MainActivity2::class.java)
                    intent.putExtra("title",title)
                    intent.putExtra("email",email)
                    intent.putExtra("password",password)
                    intent.putExtra("requestType",requestType)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(applicationContext, "Data Posting Unsuccessful", Toast.LENGTH_SHORT).show()
            }

        })

    }


}