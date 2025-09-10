package com.example.jetpackcomposepractice.composebles.lazyRowPractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLazyRow(modifier: Modifier) {

    LazyRow (
        modifier.padding(20.dp),

    ){
        items(5){ item ->
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Elem ${item + 1}")
        }
    }
}