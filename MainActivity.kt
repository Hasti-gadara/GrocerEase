package com.example.grocerease

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerease.data.local.GroceryItems
import com.example.grocerease.data.repo.GroceryDatabase
import com.example.grocerease.data.repo.GroceryRepository
import com.example.grocerease.ui.DialogListener
import com.example.grocerease.ui.GroceryItemDialog
import com.example.grocerease.ui.GroceryViewModel
import com.example.grocerease.ui.GroceryViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: GroceryViewModel
    lateinit var list: List<GroceryItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        val rvList = findViewById<RecyclerView>(R.id.rvList)

        val groceryRepository = GroceryRepository(GroceryDatabase(this))
        val factory = GroceryViewModelFactory(groceryRepository)
        viewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)

        val groceryAdapter = GroceryAdapter(listOf(), viewModel)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = groceryAdapter

        viewModel.allGroceryItems().observe(this) {
            groceryAdapter.list = it
            groceryAdapter.notifyDataSetChanged()
        }

        btnAdd.setOnClickListener {
            GroceryItemDialog(this, object : DialogListener {
                override fun onAddButtonClicked(item: GroceryItems) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}
