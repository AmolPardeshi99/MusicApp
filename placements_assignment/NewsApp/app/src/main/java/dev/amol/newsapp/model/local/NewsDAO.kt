package dev.amol.newsapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDAO {

    // insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewsData(newsList: ArrayList<NewsData>)

    // fetch all data
    @Query("select * from newsList")
    fun getAllNewsData():LiveData<List<NewsData>>

    // delete all old data
    @Query("delete from newsList")
    fun deleteAllOldData()

}