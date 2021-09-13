package com.example.unit4_codingeval_1.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.unit4_codingeval_1.recyclerview.ModelClass

class DatabaseHandler(val context: Context):
    SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {

    companion object{
        val DB_NAME = "Items"
        val DB_VERSION = 1
        val TABLE_NAME = "Item"
        val ID = "id"
        val NAME = "name"
        val DESC = "desc"
        val PRISE = "prise"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // create table query
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, " +
                "$NAME TEXT, " +
                "$DESC TEXT, " +
                "$PRISE TEXT)"

        db?.execSQL(CREATE_TABLE)
    }
    // insert
    fun insertData(name:String, desc: String, prise: String){
        val db = writableDatabase

        val values = ContentValues()
        values.put(NAME,name)
        values.put(DESC,desc)
        values.put(PRISE,prise)

        val result = db.insert(TABLE_NAME,null,values)
        if (result.toInt()==-1){
            Toast.makeText(context, "Data Insertion Failed", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
        }
    }
    // search and get data

    fun searchData(queryData : String): MutableList<ModelClass>{
        var itemList = mutableListOf<ModelClass>()
        val db = readableDatabase

         val query =  "select * from $TABLE_NAME " +
                 "where $NAME like $queryData or $DESC like $queryData"

        val cursor = db?.rawQuery(query,null)

        if (cursor!=null && cursor.count>0){
            cursor.moveToFirst()
            do {
                val id = cursor.getInt(cursor.getColumnIndex(ID))
                val name = cursor.getString(cursor.getColumnIndex(NAME))
                val desc = cursor.getString(cursor.getColumnIndex(DESC))
                val prise = cursor.getString(cursor.getColumnIndex(PRISE))

                 val modelclass = ModelClass()
                modelclass.id = id
                modelclass.name = name
                modelclass.desc = desc
                modelclass.prise = prise

                itemList.add(modelclass)
            }while (cursor.moveToNext())
        }
        return itemList
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}