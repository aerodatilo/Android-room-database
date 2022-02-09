package com.hybot.ocean_room_2022.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.hybot.ocean_room_2022.model.AppDatabase
import com.hybot.ocean_room_2022.model.ProductEntity

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    val products: LiveData<List<ProductEntity>>

    init{
        val db = AppDatabase.getDatabase(application)

        val productDao = db.productDao()

        val product1 = ProductEntity(null, "Samsung book", null)
        productDao.create(product1)

        products = productDao.selectall()
    }
}