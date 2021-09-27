package com.example.unit4_codingeval_2.model.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPizza(pizzaDataModel: PizzaDataModel)


    //getting data as live data
    @Query("select * from cart_items")
    fun getPizzas():LiveData<List<PizzaDataModel>>

    @Delete
    fun deletePizza(pizzaDataModel: PizzaDataModel)


}