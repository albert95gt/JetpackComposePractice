package com.example.jetpackcomposepractice.composebles.stickyHederPractice

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DynamicStickyHeaderList(modifier: Modifier) {
    val sections = mapOf(
        "A" to listOf("Anna", "Áron", "Attila", "Adél", "Aladár"),
        "B" to listOf("Bence", "Barbara", "Borbála", "Balázs", "Boglárka"),
        "C" to listOf("Csilla", "Csanád", "Cecília", "Csongor"),
        "D" to listOf("Dávid", "Dorina", "Dénes"),
        "E" to listOf("Eszter", "Endre"),
        "F" to listOf("Fanni", "Ferenc"),
        "G" to listOf("Gábor", "Gizella"),
        "H" to listOf("Hunor", "Hanna"),
        "I" to listOf("Imre", "Ilona"),
        "J" to listOf("Judit", "János", "József")
    )

    val allItems = sections.flatMap { (letter, names) ->
        names.map { name -> letter to name }
    }
    val listState = rememberLazyListState()
    val currentSection by remember {
        derivedStateOf {
            allItems.getOrNull(listState.firstVisibleItemIndex)?.first ?: sections.keys.first()
        }
    }

    Column (
        modifier = modifier.fillMaxSize(),
    ){
        Text(
            text = "Aktuális szekció: $currentSection",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        LazyColumn (
            state = listState,
            modifier = Modifier.fillMaxSize()
        ){
            sections.forEach { (letter, names) ->
                stickyHeader {
                    Text(
                        text = letter,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
                items(names){ name ->
                    Text(
                        text = name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}