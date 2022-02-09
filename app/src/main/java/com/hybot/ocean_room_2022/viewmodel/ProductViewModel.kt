package com.hybot.ocean_room_2022.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.hybot.ocean_room_2022.model.AppDatabase
import com.hybot.ocean_room_2022.model.ProductDao
import com.hybot.ocean_room_2022.model.ProductEntity

class ProductViewModel(application: Application) :
    AndroidViewModel(application)
{

    private val productDao : ProductDao
    val products: LiveData<List<ProductEntity>>

    init{
        val db = AppDatabase.getDatabase(application)

        productDao = db.productDao()
        products = productDao.selectAll()
    }

    fun create(product: ProductEntity){
        Thread{
            productDao.create(product)
        }.start()
    }
}