package com.example.jetpackcomposepractice.composebles.lazyColumnPractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InteractiveLazyColumn(modifier: Modifier) {
    val items = listOf("Alma", "Banán", "Cseresznye", "Dinnye", "Eper", "Körte", "Narancs")
    val favoriteStates = remember { mutableStateMapOf<String, Boolean>().apply { items.forEach { put(it, false) } } }

    LazyColumn (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(items){item->
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = if (favoriteStates[item] == true) "$item ❤️" else item)
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        favoriteStates[item] = !favoriteStates[item]!!
                    }
                ) {
                    Text(text = if (favoriteStates[item] == true) "Eltávolítás" else "Kedvenc")
                }
            }
        }
    }
}