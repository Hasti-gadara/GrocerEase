package com.example.grocerease.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerease.R
import com.example.grocerease.data.local.GroceryItems


class GroceryItemDialog(context: Context, private var dialogListener: DialogListener) : AppCompatDialog(context) {
    private lateinit var etItemName : EditText
    private lateinit var etItemQuantity : EditText
    private lateinit var spItemUnit : Spinner
    private lateinit var etItemPrice : EditText
    private lateinit var tvSave : TextView
    private lateinit var tvCancel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.grocerydialog)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        etItemName = findViewById(R.id.etItemName)!!
        etItemQuantity = findViewById(R.id.etItemQuantity)!!
        spItemUnit = findViewById(R.id.spItemUnit)!!
        etItemPrice = findViewById(R.id.etItemPrice)!!
        tvSave = findViewById(R.id.tvSave)!!
        tvCancel = findViewById(R.id.tvCancel)!!

        etItemName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val name = s.toString().lowercase().trim()
                updateUnitSpinner(name)
            }
        })

        // Click listener on Save button
        // to save all data.
        tvSave.setOnClickListener {
            val name = etItemName.text.toString().trim()
            val quantityStr = etItemQuantity.text.toString().trim()
            val unit = spItemUnit.selectedItem.toString()
            val priceStr = etItemPrice.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(context, "Please Enter Item Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (quantityStr.isEmpty()) {
                Toast.makeText(context, "Please Enter Quantity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (priceStr.isEmpty()) {
                Toast.makeText(context, "Please Enter Price", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val quantity = quantityStr.toInt()
            val price = priceStr.toInt()

            val item = GroceryItems(name, quantity, unit, price)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }

        // On click listener on cancel text to close dialog box
        tvCancel.setOnClickListener {
            cancel()
        }
    }

    private fun updateUnitSpinner(name: String) {
        val adapter = when {
            isLiquid(name) -> {
                ArrayAdapter.createFromResource(context, R.array.units_liquid, android.R.layout.simple_spinner_item)
            }
            isWeight(name) -> {
                ArrayAdapter.createFromResource(context, R.array.units_weight, android.R.layout.simple_spinner_item)
            }
            else -> {
                ArrayAdapter.createFromResource(context, R.array.units_general, android.R.layout.simple_spinner_item)
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spItemUnit.adapter = adapter
    }

    private fun isLiquid(name: String): Boolean {
        val liquids = listOf("milk", "water", "juice", "oil", "cold drink", "tea", "coffee")
        return liquids.any { name.contains(it) }
    }

    private fun isWeight(name: String): Boolean {
        val weights = listOf("potato", "onion", "tomato", "vegetable", "apple", "banana", "kiwi", "orange", "mango", "sugar", "salt", "rice", "dal")
        return weights.any { name.contains(it) }
    }
}