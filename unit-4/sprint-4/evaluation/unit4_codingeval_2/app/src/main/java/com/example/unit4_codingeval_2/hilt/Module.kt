package com.example.unit4_codingeval_2.hilt

import com.example.unit4_codingeval_2.model.local.PizzaDao
import com.example.unit4_codingeval_2.model.local.PizzaRoomDataBase
import com.example.unit4_codingeval_2.model.remote.retrofit.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module{


    @Singleton
    @Provides
    fun provideAPIService():APIService{
        val builder = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/shivarajp/04af4846333e3c61a8d84d310915c75d/raw/a8a1bd18d7ca7f59dc56784b211044864beba831/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIService::class.java)
    }


//    @Singleton
//    @Provides
//    fun provideRoomDb():PizzaRoomDataBase{
//
//    }
//
//
//    @Singleton
//    @Provides
//    fun provideDaoObject(): PizzaDao{
//
//    }
}