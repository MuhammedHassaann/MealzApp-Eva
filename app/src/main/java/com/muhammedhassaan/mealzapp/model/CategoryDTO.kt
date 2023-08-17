package com.muhammedhassaan.mealzapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("categories")
data class CategoryDTO(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val imgUrl: String
)
