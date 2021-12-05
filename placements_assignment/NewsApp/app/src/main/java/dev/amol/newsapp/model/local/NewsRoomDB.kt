package dev.amol.newsapp.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsData::class], version = 1)
abstract class NewsRoomDB: RoomDatabase() {

    abstract fun getNewsDAO():NewsDAO
}