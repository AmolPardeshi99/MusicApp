package dev.amol.musicapp.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.musicapp.R
import dev.amol.musicapp.databinding.ActivityMainBinding
import dev.amol.musicapp.model.remote.api.Status
import dev.amol.musicapp.model.remote.responsedata.Result
import dev.amol.musicapp.ui.adapter.MusicAdapter
import dev.amol.musicapp.viewmodel.MusicViewModel
import android.net.NetworkInfo

import android.net.ConnectivityManager
import android.util.Log
import dev.amol.musicapp.model.local.MusicData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.InetAddress
import java.net.UnknownHostException


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel: MusicViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    private var musicDataList = ArrayList<Result>()
    lateinit var musicAdapter: MusicAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setRecyclerView()
        activityMainBinding.floatingSearchView.setOnQueryChangeListener { oldQuery, newQuery ->
            loadData(newQuery)
        }
    }

    private fun loadData(term: String) {

        // if internet is available
        //if (isInternetAvailable()){
            mainViewModel.getMusicListFromAPI(term).observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        musicDataList.clear()
                        it?.data?.let { it1 -> mainViewModel.addDataFromAPIToDB(it1) }
                        it.data?.results?.let {
                            musicDataList.addAll(it)
                        }
                        musicAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Network error! Please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
            // if internet is not available -->
        //}else{
            mainViewModel.getArtistFromDB(term).observe(this, Observer {
                getDataInResultList(it)
            })
       // }
    }

    // getting data in form  of result list from MusicData
    private fun getDataInResultList(it: List<MusicData>?){
        it?.forEach {
            val result = Result(1,it.artistName,"",it.artworkUrl100,"",
                "",1,"","",
                "","",0.2,2,it.collectionName,
                2.0,"","","","",1,2,
                true,true,"","","","","",
                "","",2,"",2.0,2.1,5,
                "",5,5.2,2.5,5,"","")
         musicDataList.add(result)
        }
       musicAdapter.notifyDataSetChanged()
    }


    fun isInternetAvailable(): Boolean {
        var isInternetAvail = false;
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val address: InetAddress = InetAddress.getByName("www.google.com")
                isInternetAvail = !address.equals("")
            } catch (e: UnknownHostException) {
                Log.d(TAG, "isInternetAvailable: ${e.toString()}")
            }
        }
        return isInternetAvailable()
    }

    private fun setRecyclerView() {
        musicAdapter = MusicAdapter(this, musicDataList)
        activityMainBinding.recyclerAddress.apply {
            adapter = musicAdapter
            layoutManager = GridLayoutManager(context,2)
        }
    }


}