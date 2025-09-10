package com.example.jetpackcomposepractice.composebles.lazyRowPractice

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SelectableLazyRow(modifier: Modifier) {
    val context = LocalContext.current
    var selectedItem by remember { mutableIntStateOf(-1) }

    LazyRow (
        modifier.padding(20.dp)
    ){
        items(10){item ->
            Card (
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
                    .clickable(
                        true,
                        onClick = {
                            selectedItem = item
                            Toast.makeText(
                                context,
                                "Kiválasztva: Elem ${item + 1}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ),
                elevation = CardDefaults.cardElevation(23.dp),
                colors = if (selectedItem == item) CardDefaults.cardColors(Color.Blue) else CardDefaults.cardColors(
                    Color.Gray)

            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Elem ${item + 1}",
                        color = Color.White
                    )
                }
            }
        }
    }
}