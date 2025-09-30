package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposepractice.composebles.lazyColumnPractice.CardFilterLazyColumn
import com.example.jetpackcomposepractice.composebles.lazyColumnPractice.InteractiveLazyColumn
import com.example.jetpackcomposepractice.composebles.lazyColumnPractice.SortedDetailLazyColumn
import com.example.jetpackcomposepractice.composebles.lazyRowPractice.FruitCardLazyRow
import com.example.jetpackcomposepractice.composebles.lazyRowPractice.SelectableLazyRow
import com.example.jetpackcomposepractice.composebles.lazyRowPractice.SimpleLazyRow
import com.example.jetpackcomposepractice.composebles.modifierPractice.CenteredTextPractice
import com.example.jetpackcomposepractice.composebles.modifierPractice.SimpleBoxPractice
import com.example.jetpackcomposepractice.composebles.stickyHederPractice.DynamicStickyHeaderList
import com.example.jetpackcomposepractice.composebles.stickyHederPractice.MultiSectionStickyList
import com.example.jetpackcomposepractice.composebles.stickyHederPractice.SimpleStickyHeaderList
import com.example.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CenteredTextPractice(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePracticeTheme {

    }
}