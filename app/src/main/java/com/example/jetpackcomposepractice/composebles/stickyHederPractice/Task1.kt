package com.example.jetpackcomposepractice.composebles.stickyHederPractice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleStickyHeaderList(modifier: Modifier) {
    LazyColumn (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        stickyHeader {
            Text(text = "Fejléc")
        }

        items(count = 5){item ->
            Text(text = "Elem ${item + 1}")
        }
    }
}