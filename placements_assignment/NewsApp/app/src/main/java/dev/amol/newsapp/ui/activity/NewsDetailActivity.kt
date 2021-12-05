package dev.amol.newsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import dev.amol.newsapp.R
import dev.amol.newsapp.databinding.ActivityNewsDetailBinding
import dev.amol.newsapp.model.local.NewsData

class NewsDetailActivity : AppCompatActivity() {

    lateinit var activityNewsDetailBinding:ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNewsDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_news_detail)

        val newsData: NewsData = intent?.getSerializableExtra("article") as NewsData
        setViewData(newsData)
    }

    private fun setViewData(newsData: NewsData) {
        activityNewsDetailBinding.apply {
            articleDetail = newsData
            Glide.with(ivNewsImg).load(newsData.urlToImage).into(ivNewsImg)
        }
    }
}