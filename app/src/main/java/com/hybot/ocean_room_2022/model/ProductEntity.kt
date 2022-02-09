package com.hybot.ocean_room_2022.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Long?,
    val name: String,
    val imageUrl: String?
)
