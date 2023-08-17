package com.muhammedhassaan.mealzapp.screens

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedhassaan.mealzapp.local.CategoryDatabase
import com.muhammedhassaan.mealzapp.model.Category
import com.muhammedhassaan.mealzapp.model.CategoryDTO
import com.muhammedhassaan.mealzapp.model.asCategoryDTO
import com.muhammedhassaan.mealzapp.remote.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel(application: Application): AndroidViewModel(application) {

    var list by mutableStateOf(emptyList<Category>())
    private lateinit var categoryDatabase: CategoryDatabase

    init {
        getMeals()
        categoryDatabase = CategoryDatabase.getDatabase(application.applicationContext)
    }

    private fun getMeals(){
        viewModelScope.launch(Dispatchers.IO) {
            list = RetrofitFactory.apiService.getCategories().categories
        }
    }

    fun insertMeal(category: Category){
        viewModelScope.launch(Dispatchers.IO) {
            categoryDatabase.categoryDao().insertCategory(category.asCategoryDTO())
        }
    }

}