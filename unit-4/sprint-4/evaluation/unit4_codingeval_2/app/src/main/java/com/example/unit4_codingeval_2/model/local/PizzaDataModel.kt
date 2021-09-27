package com.example.unit4_codingeval_2.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.StringBuilder


@Entity(tableName = "cart_items")
data class PizzaDataModel(
    @ColumnInfo(name = "name") var name:String?,
    @ColumnInfo(name = "desc") var desc :String?,
    @ColumnInfo(name= "prise") var prise : Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var ID: Int? = null
}