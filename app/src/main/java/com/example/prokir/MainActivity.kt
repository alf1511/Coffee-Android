package com.example.prokir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prokir.database.*
import com.example.prokir.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "db")
//            .fallbackToDestructiveMigration()
//            .build()
        val fragOne = FragmentOne()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_frag, fragOne)
            commit()
        }

    }
//    private fun initData(){
//        val cust1 = Customer("Jang Hyun", "Korea", "08237141234")
//        val cust2 = Customer("Kim Chang", "Italy", "08237141235")
////        db.customerDao().insert(cust1, cust2)
//    }
}