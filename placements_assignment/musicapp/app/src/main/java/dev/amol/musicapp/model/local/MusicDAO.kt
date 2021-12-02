package dev.amol.musicapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MusicDAO {

    // insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMusicList(musicList: ArrayList<MusicData>)

    // fetch all data
    @Query("select * from musicList")
    fun getAllMusic(): LiveData<List<MusicData>>

    // delete all data
    @Query("delete from musicList")
    fun deleteAll()

    // fetch artist from data
    @Query("select * from musicList where artistName LIKE '%' || :artist || '%'")
    fun getArtist(artist: String): LiveData<List<MusicData>>

}


//    // fetch artist from data
//    @Query("select * from musicList where artistName like '% :artist'")
//    fun getArtist(artist:String):LiveData<List<MusicData>>