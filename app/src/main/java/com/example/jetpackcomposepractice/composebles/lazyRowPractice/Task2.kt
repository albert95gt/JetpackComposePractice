package com.example.jetpackcomposepractice.composebles.lazyRowPractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FruitCardLazyRow(modifier: Modifier) {
    val fruits = listOf("Alma", "Banán", "Narancs", "Körte", "Szilva")

    LazyRow  (
        modifier.padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(fruits){ fruit ->
            Card (
                modifier = Modifier
                    .size(100.dp, 80.dp)
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(20.dp)
            ){
                Text(text = fruit)
            }
        }
    }
}