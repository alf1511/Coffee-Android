package com.example.prokir.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class, Product::class, Order::class, OrderItems::class], version = 5, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): AppDao
    companion object{
        val DB_NAME = "Coffe PSI"
        @Volatile
        var INSTANCE:AppDatabase?=null
        fun getInstance(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}