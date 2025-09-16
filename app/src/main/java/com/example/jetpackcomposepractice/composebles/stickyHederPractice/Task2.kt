package com.example.jetpackcomposepractice.composebles.stickyHederPractice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MultiSectionStickyList(modifier: Modifier) {
    val sections = mapOf(
        "A" to listOf("Anna", "Áron"),
        "B" to listOf("Bence", "Barbara")
    )

    LazyColumn (modifier = modifier.fillMaxSize()){
        sections.forEach { (letter, names) ->
            stickyHeader {
                Text(
                    text = letter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Gray)
                        .padding(8.dp)
                )
            }
            items(names){ name ->
                Text(text = name)
            }
        }
    }
}