package dev.amol.musicapp.repository

import androidx.lifecycle.LiveData
import dev.amol.adresssearchapp.data.remote.APIService
import dev.amol.musicapp.model.local.MusicDAO
import dev.amol.musicapp.model.local.MusicData
import dev.amol.musicapp.model.remote.api.Resource
import dev.amol.musicapp.model.remote.api.ResponseHandler
import dev.amol.musicapp.model.remote.responsedata.ResponseData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MusicRepo @Inject constructor(val apiService: APIService, val musicDAO: MusicDAO) {

    //private val apiService = ServiceHelper.getAPI()
    private val responseHandler = ResponseHandler()

    suspend fun fetchDataRetrofit(term:String):Resource<ResponseData>{
        return try {
            val responseData = apiService.getMusicDataFromAPI(term)
            return responseHandler.handleSuccess(responseData)
        }catch (exception:Exception){
            responseHandler.handleException(exception)
        }
    }

    fun getDataFromRoom(artistName:String):LiveData<List<MusicData>>{
        return musicDAO.getArtist(artistName)
    }

    fun saveToDB(responseData: ResponseData){
        val listOfMusic = ArrayList<MusicData>()
        responseData.results.forEach {
            if (it.collectionName!=null && it.artistName!=null && it.artworkUrl100!=null){
                val newMusic = MusicData(it.artistName,it.artworkUrl100,it.collectionName)
                listOfMusic.add(newMusic)
            }
        }
        musicDAO.deleteAll()
        musicDAO.addMusicList(listOfMusic)
    }


    fun deleteAllDataFromDB(){
        CoroutineScope(Dispatchers.IO).launch {
            musicDAO.deleteAll()
        }
    }
}