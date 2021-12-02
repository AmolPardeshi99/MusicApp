package dev.amol.musicapp.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MusicData::class], version = 1)
abstract class MusicRoomDataBase:RoomDatabase() {

    abstract fun getMusicDAO():MusicDAO

}





//companion object{
//    private var INSTANCE: MusicRoomDataBase?=null
//    fun getDBObject(context: Context):MusicRoomDataBase{
//        if(INSTANCE==null){
//            val builder = Room.databaseBuilder(
//                context.applicationContext,
//                MusicRoomDataBase::class.java,
//                "music_db"
//            )
//            INSTANCE =builder.build()
//            return INSTANCE as MusicRoomDataBase
//
//        }else  return INSTANCE as MusicRoomDataBase
//    }
//
//}