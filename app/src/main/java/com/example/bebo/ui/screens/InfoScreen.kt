package com.example.bebo.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bebo.composables.ScreenTopBar

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Info", navController) },
    ) { innerPadding ->
        Text(text = "Info Screen", modifier = Modifier.padding(innerPadding))
    }
}

//@Composable
//fun InfoScreen(modifier: Modifier) {
//    Text(text = "Info Screen", modifier = modifier)
//}