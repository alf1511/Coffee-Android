package com.example.prokir.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @ColumnInfo(name = "namaProduk") val namaProduk: String?,
    @ColumnInfo(name = "harga") val harga: Int?,
    @ColumnInfo(name = "stok") val stok: Int?,
    @ColumnInfo(name = "imagePath") val imagePath: String?
){
    @PrimaryKey(autoGenerate = true)
    var product_id: Int? = null
}