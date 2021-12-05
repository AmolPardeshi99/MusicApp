package dev.amol.newsapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import dev.amol.newsapp.model.local.NewsDAO
import dev.amol.newsapp.model.local.NewsData
import dev.amol.newsapp.model.remote.api.APIService
import dev.amol.newsapp.model.remote.api.ResponseHandler
import dev.amol.newsapp.model.remote.responsedata.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsRepo @Inject constructor(val apiService: APIService, val newsDAO: NewsDAO) {

    private val responseHandler = ResponseHandler()

    fun fetchDataFromAPI() {
        CoroutineScope(IO).launch {
            try {
                val articleList: List<Article> = apiService.getNewsFromAPI().articles
                val listOfNewsData = ArrayList<NewsData>()
                articleList.forEach {
                    listOfNewsData.add(
                        NewsData(
                            it.author,
                            it.content,
                            it.description,
                            it.publishedAt,
                            it.title,
                            it.url,
                            it.urlToImage
                        )
                    )
                }
                newsDAO.deleteAllOldData()
                newsDAO.addNewsData(listOfNewsData)
            } catch (e: Exception) {
                Log.d("Amol", "fetchDataFromAPI: $e")
            }
        }
    }

    fun getDataFromRoom(): LiveData<List<NewsData>> {
        return newsDAO.getAllNewsData()
    }

    fun deleteAllDataFromDB() {
        CoroutineScope(IO).launch {
            newsDAO.deleteAllOldData()
        }
    }

}