package com.muhammedhassaan.mealzapp.remote

import com.muhammedhassaan.mealzapp.model.Meals
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): Meals
    
}