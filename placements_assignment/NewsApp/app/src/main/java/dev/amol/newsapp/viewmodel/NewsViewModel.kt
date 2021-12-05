package dev.amol.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.newsapp.model.local.NewsData
import dev.amol.newsapp.repository.NewsRepo
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val newsRepo: NewsRepo):ViewModel() {

    fun getDataFromRoomDB():LiveData<List<NewsData>>{
        return newsRepo.getDataFromRoom()
    }

    fun deleteAllRoomData(){
        newsRepo.deleteAllDataFromDB()
    }
    fun fetchDataFromAPI(){
        newsRepo.fetchDataFromAPI()
    }
}