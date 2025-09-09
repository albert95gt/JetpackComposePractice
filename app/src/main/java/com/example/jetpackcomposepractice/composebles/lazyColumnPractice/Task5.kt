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

data class Fruit(val name: String, val price: Int)
val fruits = listOf(
    Fruit("Alma", 300),
    Fruit("Banán", 400),
    Fruit("Cseresznye", 600),
    Fruit("Dinnye", 800),
    Fruit("Eper", 700),
    Fruit("Körte", 350),
    Fruit("Narancs", 450)
)

@Composable
fun SortedDetailLazyColumn(modifier: Modifier) {
    val favoriteStates = remember { mutableStateMapOf<String, Boolean>().apply { fruits.forEach { put(it.name, false) } } }
    var sortingState by remember { mutableStateOf(true) }
    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        Button(
            onClick = {
                sortingState = !sortingState
            }
        ) {
            Text(text = if (sortingState) "növekvő" else "csökkenő")
        }
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(items = if (sortingState) fruits.sortedBy { it.price } else fruits.sortedByDescending { it.price }){ fruit ->

                Card (
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ){
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = if (favoriteStates[fruit.name] == true) "❤️${fruit.name}" else fruit.name,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${fruit.price} Ft",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Button(onClick = {
                            favoriteStates[fruit.name] = !favoriteStates[fruit.name]!!
                        }) {
                            Text(text = if (favoriteStates[fruit.name] == true) "Eltávolítás" else "Kedvenc")
                        }
                    }
                }
            }
        }
    }

}