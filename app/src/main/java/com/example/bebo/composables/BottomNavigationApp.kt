package com.example.bebo.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bebo.ui.appbars.BottomBar
import com.example.bebo.ui.appbars.TopBar
import com.example.bebo.ui.screens.FavoriteScreen
import com.example.bebo.ui.screens.InfoScreen
import com.example.bebo.ui.screens.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun BottomNavigationApp() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(navController) },
        bottomBar = { BottomBar(navController) }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        NavHost(
            navController = navController, startDestination = "main"
        ) {
            composable(route = "main") {
                MainScreen(navController)
            }
            composable(route = "info") {
                InfoScreen(navController)
            }
            composable(route = "favorite") {
                FavoriteScreen(navController)
            }
        }
    }

}