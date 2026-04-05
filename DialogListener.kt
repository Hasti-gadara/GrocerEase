package com.example.grocerease.ui

import com.example.grocerease.data.local.GroceryItems


interface DialogListener {

    // Create a function to add items
    // in GroceryItems on clicking
    fun onAddButtonClicked(item: GroceryItems)
}