package com.example.unit4_codingeval_2.model.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [PizzaDataModel::class],version = 1)
abstract class PizzaRoomDataBase:RoomDatabase() {

    abstract fun getPizzaDao():PizzaDao

    companion object{


        private var Instance:PizzaRoomDataBase? = null


    }
}