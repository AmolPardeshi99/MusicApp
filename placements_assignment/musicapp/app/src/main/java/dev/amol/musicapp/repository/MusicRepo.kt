package dev.amol.musicapp.repository

import dev.amol.adresssearchapp.data.remote.APIService
import dev.amol.musicapp.model.local.MusicDAO
import dev.amol.musicapp.model.remote.api.Resource
import dev.amol.musicapp.model.remote.api.ResponseHandler
import dev.amol.musicapp.model.remote.responsedata.ResponseData
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
}