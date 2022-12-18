package com.example.prokir

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prokir.database.AppDao
import com.example.prokir.database.AppDatabase
import com.example.prokir.database.Customer
import com.example.prokir.databinding.FragmentOneBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentOne : Fragment(R.layout.fragment_one)
{
    private lateinit var dao: AppDao
    private lateinit var binding: FragmentOneBinding
    private lateinit var recyclerView: RecyclerView
    private  lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dao = AppDatabase.getInstance(requireContext()).getDao()
        recyclerView = view.findViewById(R.id.records)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        GlobalScope.launch {
//            dao.deleteAllCustomer()
            initData() //memanggil function di dalam coroutine
            Log.i(null, dao.getAllCustomers().size.toString())
//            val data =
//            binding.records.layoutManager = LinearLayoutManager(parentFragment?.context)
            adapter = TransactionAdapter(dao.getAllCustomers())
            recyclerView.adapter = adapter
        }
    }

    private fun initData(){
//        val cust1 = Customer("Jang Hyun", "Korea", "08237141234")
//        val cust2 = Customer("Pesa Chang", "Italy", "08237141235")
//        dao.insert(cust1, cust2)
    }
}