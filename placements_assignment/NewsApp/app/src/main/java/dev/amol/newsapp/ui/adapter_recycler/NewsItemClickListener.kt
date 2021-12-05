package dev.amol.newsapp.ui.adapter_recycler

import dev.amol.newsapp.model.local.NewsData

interface NewsItemClickListener {

    fun onNewsItemClicked(newsData: NewsData)
}