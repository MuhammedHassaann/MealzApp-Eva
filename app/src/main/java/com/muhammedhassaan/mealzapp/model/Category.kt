package com.muhammedhassaan.mealzapp.model

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun Category.asCategoryDTO(): CategoryDTO{
    return CategoryDTO(
            id = idCategory,
            name = strCategory,
            description = strCategoryDescription,
            imgUrl = strCategoryThumb
    )
}
