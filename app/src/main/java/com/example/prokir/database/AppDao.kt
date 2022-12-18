package com.example.prokir.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {
//    customer
    @Query("SELECT * FROM customer")
    fun getAllCustomers():List<Customer>

    @Insert
    fun insert(vararg customer: Customer)

    @Delete
    fun delete(customer: Customer)

    @Query("DELETE FROM customer")
    fun deleteAllCustomer()
//    order
    @Query("SELECT * FROM `order`")
    fun getAllOrders():List<Order>

    @Insert
    fun insert(vararg order: Order)

    @Delete
    fun delete(order: Order)

    @Query("DELETE FROM `order`")
    fun deleteAllOrder()
//    orderitems
    @Query("SELECT * FROM orderitems")
    fun getAllOrderItems():List<OrderItems>

    @Insert
    fun insert(vararg orderItems: OrderItems)

    @Delete
    fun delete(orderItems: OrderItems)

    @Query("DELETE FROM orderitems")
    fun deleteAllOrderItems()
//    product
    @Query("SELECT * FROM product")
    fun getAllProducts():List<Product>

    @Insert
    fun insert(vararg product: Product)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product")
    fun deleteAllProducts()
}