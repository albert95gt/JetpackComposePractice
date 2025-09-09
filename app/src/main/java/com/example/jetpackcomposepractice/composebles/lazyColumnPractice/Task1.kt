package com.example.jetpackcomposepractice.composebles.lazyColumnPractice

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BasicLazyColumn(modifier: Modifier) {
    LazyColumn (
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(10){ item ->
            Text(text = "Elem ${item + 1}")
        }
    }
}

