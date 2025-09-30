package com.example.jetpackcomposepractice.composebles.modifierPractice

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BorderedTextPractice(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome back to Compose world!",
        modifier = modifier
            .border(width = 1.dp, color = Color.Red)
            .background(color = Color.Yellow)
            .clickable(
                onClick = {
                    Log.d("Click message", "Text clicked!")
                }
            )
    )
}