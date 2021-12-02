package dev.amol.musicapp.ui.activity

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


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel: MusicViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    private var musicDataList = ArrayList<Result>()
    lateinit var musicAdapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setRecyclerView()
        activityMainBinding.floatingSearchView.setOnQueryChangeListener { oldQuery, newQuery ->
            loadData(newQuery)
        }
    }

    private fun loadData(term: String) {
        mainViewModel.getMusicListFromAPI(term).observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    musicDataList.clear()

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
    }

    private fun setRecyclerView() {
        musicAdapter = MusicAdapter(this, musicDataList)
        activityMainBinding.recyclerAddress.apply {
            adapter = musicAdapter
            layoutManager = GridLayoutManager(context,2)
        }
    }
}