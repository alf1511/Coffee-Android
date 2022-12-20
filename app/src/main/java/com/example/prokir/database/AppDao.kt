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

    @Query("SELECT * FROM customer WHERE cust_id = :id")
    fun searchCustomerById(id: Int): Customer
//    order
    @Query("SELECT * FROM `order`")
    fun getAllOrders():List<Order>

    @Insert
    fun insert(vararg order: Order)

    @Delete
    fun delete(order: Order)

    @Query("DELETE FROM `order`")
    fun deleteAllOrder()

    @Query("SELECT * FROM `order` ORDER BY order_id DESC LIMIT 1")
    fun getNewestOrder(): Order

//    orderitems
    @Query("SELECT * FROM orderitems")
    fun getAllOrderItems():List<OrderItems>

    @Insert
    fun insert(vararg orderItems: OrderItems)

    @Delete
    fun delete(orderItems: OrderItems)

    @Query("DELETE FROM orderitems")
    fun deleteAllOrderItems()

    @Query("SELECT * FROM orderitems WHERE order_id=:order_id")
    fun searchOrderItemsById(order_id: Int): List<OrderItems>

//    product
    @Query("SELECT * FROM product")
    fun getAllProducts():List<Product>

    @Insert
    fun insert(vararg product: Product)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product")
    fun deleteAllProducts()

    @Query("SELECT * FROM product WHERE product_id = :id")
    fun searchProductById(id: Int): Product
}