package com.example.bebo.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bebo.composables.MainTopAppBar
import com.example.bebo.composables.ScreenTopBar

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { MainTopAppBar("My app", navController) },
    ) { innerPadding ->
        Text(text = "Home Screen", modifier = Modifier.padding(innerPadding))
    }
}

//@Composable
//fun MainScreen(modifier: Modifier) {
//    Text(text = "Home Screen", modifier = modifier)
//}


