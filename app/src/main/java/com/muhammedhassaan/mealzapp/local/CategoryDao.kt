package com.muhammedhassaan.mealzapp.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammedhassaan.mealzapp.model.CategoryDTO


@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryDTO: CategoryDTO)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<CategoryDTO>

    @Query("SELECT * FROM categories WHERE id=:id")
    suspend fun getCategoryById(id: Int): CategoryDTO
}