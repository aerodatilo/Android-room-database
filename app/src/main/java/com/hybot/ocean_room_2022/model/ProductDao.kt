package com.hybot.ocean_room_2022.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun create(product: ProductEntity)
    @Query("SELECT * FROM products")
    fun selectAll(): LiveData<List<ProductEntity>>
}