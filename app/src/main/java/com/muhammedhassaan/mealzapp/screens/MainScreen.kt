package com.muhammedhassaan.mealzapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.muhammedhassaan.mealzapp.model.Category
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(context: Context){
    val vm = viewModel<MealViewModel>()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ){
        items(vm.list){
            MealItem(category = it ){category->
                vm.insertMeal(category)
            }
        }
    }
}


@Composable
fun MealItem(
    category: Category,
    onItemClick: (Category)->Unit
){
    Card(
        modifier = Modifier
            .height(50.dp)
            .padding(8.dp)
            .clickable {onItemClick(category)},
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = category.idCategory, modifier = Modifier.weight(0.2f))
            Text(text = category.strCategory, modifier = Modifier.weight(0.8f))
        }
    }
}
