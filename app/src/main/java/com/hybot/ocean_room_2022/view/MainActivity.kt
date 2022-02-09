package com.hybot.ocean_room_2022.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.hybot.ocean_room_2022.R
import com.hybot.ocean_room_2022.model.ProductEntity
import com.hybot.ocean_room_2022.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etProduct = findViewById<EditText>(R.id.etProduct)
        val btAddProduct = findViewById<Button>(R.id.btAddProduct)
        val tvProductName = findViewById<TextView>(R.id.tvProductName)

        val productViewModel: ProductViewModel =
            ViewModelProvider(this)
                .get(ProductViewModel::class.java)

        productViewModel.products.observe(
            this, {
                tvProductName.text = "Produtos: "
                    it.forEach{
                            product ->
                        tvProductName.append("${product.name}\n")
                }
            }
        )

        btAddProduct.setOnClickListener {
            val productName = etProduct.text.toString()
            val newProduct = ProductEntity(null, productName, null)
            productViewModel.create(newProduct)
        }
    }
}