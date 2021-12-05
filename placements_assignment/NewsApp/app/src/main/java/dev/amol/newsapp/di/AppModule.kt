package dev.amol.newsapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.amol.newsapp.model.Utility
import dev.amol.newsapp.model.local.NewsDAO
import dev.amol.newsapp.model.local.NewsRoomDB
import dev.amol.newsapp.model.remote.api.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAPIService():APIService {
        val builder = Retrofit.Builder()
            .baseUrl(Utility.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context):NewsRoomDB{
        val builder = Room.databaseBuilder(
            context.applicationContext,
            NewsRoomDB::class.java,
            "news_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideTaskDao(db: NewsRoomDB): NewsDAO{
        return db.getNewsDAO()
    }
}