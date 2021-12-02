package dev.amol.musicapp.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musicList")
data class MusicData(
    @ColumnInfo(name = "artistName")var artistName:String,
    @ColumnInfo(name = "artworkUrl100")var artworkUrl100:String,
    @ColumnInfo(name = "collectionName")var collectionName:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int?=null
}
