package com.hybot.ocean_room_2022.model

import androidx.room.Entity

@Entity (tableName = "products")
data class ProductEntity(
    val id: Long?,
    val name: String,
    val imageUrl: String?
)
