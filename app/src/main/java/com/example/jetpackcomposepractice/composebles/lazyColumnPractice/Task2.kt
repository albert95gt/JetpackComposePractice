package com.example.jetpackcomposepractice.composebles.lazyColumnPractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DynamicLazyColumn(modifier: Modifier) {
    val items = listOf(
        "Alma",
        "Banán",
        "Cseresznye",
        "Dinnye",
        "Eper",
        "Körte",
        "Narancs"
    )

    LazyColumn (
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(items){ item ->
            Text(
                text = item
            )
        }
    }
}