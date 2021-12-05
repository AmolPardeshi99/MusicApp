package dev.amol.newsapp.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.amol.newsapp.model.remote.responsedata.Source
import java.io.Serializable

@Entity(tableName = "newsList")
data class NewsData(
    @ColumnInfo(name ="author" )var author:String?,
    @ColumnInfo(name ="content" )var content: String?,
    @ColumnInfo(name ="description" )var description: String,
    @ColumnInfo(name ="publishedAt" )var publishedAt: String,
    @ColumnInfo(name = "title")var title: String,
    @ColumnInfo(name ="url" )var url: String,
    @ColumnInfo(name ="urlToImage" )var urlToImage: String
    ):Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")var id:Int?=null
}


