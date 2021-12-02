package dev.amol.musicapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.musicapp.model.remote.api.Resource
import dev.amol.musicapp.model.remote.responsedata.ResponseData
import dev.amol.musicapp.repository.MusicRepo
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class MusicViewModel @Inject constructor(val musicRepo:MusicRepo):ViewModel() {

    fun getMusicListFromAPI(term:String):LiveData<Resource<ResponseData>>{
        return liveData(Dispatchers.IO) {

            emit(Resource.loading(null))
            val response = musicRepo.fetchDataRetrofit(term)
            emit(response)

        }
    }
}