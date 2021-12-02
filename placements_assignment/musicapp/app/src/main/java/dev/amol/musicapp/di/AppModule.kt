package dev.amol.musicapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.amol.adresssearchapp.data.remote.APIService
import dev.amol.musicapp.model.local.MusicDAO
import dev.amol.musicapp.model.local.MusicRoomDataBase
import dev.amol.musicapp.model.utils.Utility
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAPIService(): APIService {
        val builder  = Retrofit.Builder()
            .baseUrl(Utility.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context):MusicRoomDataBase{
        val builder = Room.databaseBuilder(
            context.applicationContext,
            MusicRoomDataBase::class.java,
            "music_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideTaskDao(db: MusicRoomDataBase): MusicDAO{
        return db.getMusicDAO()
    }
}