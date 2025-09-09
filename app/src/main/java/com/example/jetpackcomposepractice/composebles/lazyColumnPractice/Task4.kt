package com.example.jetpackcomposepractice.composebles.lazyColumnPractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardFilterLazyColumn(modifier: Modifier = Modifier) {
    val items = listOf("Alma", "Banán", "Cseresznye", "Dinnye", "Eper", "Körte", "Narancs")
    val favoriteStates = remember { mutableStateMapOf<String, Boolean>().apply { items.forEach { put(it, false) } } }
    var filterState by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        TextField(
            value = filterState,
            onValueChange = { newText ->
                filterState = newText
            },
            label = { Text(text = "Filter by fruit name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.filter { it.contains(filterState, ignoreCase = true) }) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = if (favoriteStates[item] == true) "$item ❤️" else item,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            favoriteStates[item] = !favoriteStates[item]!!
                        }) {
                            Text(text = if (favoriteStates[item] == true) "Eltávolítás" else "Kedvenc")
                        }
                    }
                }
            }
        }
    }
}