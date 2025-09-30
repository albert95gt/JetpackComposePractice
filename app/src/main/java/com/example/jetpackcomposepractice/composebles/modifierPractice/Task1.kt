package com.example.jetpackcomposepractice.composebles.modifierPractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SimpleBoxPractice(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
            .background(color = Color.Blue)
    )
}