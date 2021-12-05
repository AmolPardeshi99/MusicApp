package dev.amol.newsapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.newsapp.R
import dev.amol.newsapp.databinding.ActivityMainBinding
import dev.amol.newsapp.model.local.NewsData
import dev.amol.newsapp.model.remote.responsedata.Article
import dev.amol.newsapp.ui.adapter_recycler.NewsAdapter
import dev.amol.newsapp.ui.adapter_recycler.NewsItemClickListener
import dev.amol.newsapp.viewmodel.NewsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NewsItemClickListener {

    val newsViewModel: NewsViewModel by viewModels()
    lateinit var activityMainBinding: ActivityMainBinding
    private var newsArticleList = ArrayList<NewsData>()
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadData()
        setRecycler()
    }


    private fun setRecycler() {
        newsAdapter = NewsAdapter(newsArticleList, this)
        activityMainBinding.newsRecycler.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun loadData() {
        CoroutineScope(Main).launch {
            newsViewModel.fetchDataFromAPI()
        }
        newsViewModel.getDataFromRoomDB().observe(this@MainActivity, Observer {
            newsArticleList.clear()
            newsArticleList.addAll(it)
            newsAdapter.notifyDataSetChanged()
        })
    }

    override fun onNewsItemClicked(article: NewsData) {
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("article", article)
        startActivity(intent)
    }
}