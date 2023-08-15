package com.muhammedhassaan.mealzapp.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedhassaan.mealzapp.model.Category
import com.muhammedhassaan.mealzapp.remote.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel: ViewModel() {

    var list by mutableStateOf(emptyList<Category>())

    init {
        getMeals()
    }

    private fun getMeals(){
        viewModelScope.launch(Dispatchers.IO) {
            list = RetrofitFactory.apiService.getCategories().categories
        }
    }
}