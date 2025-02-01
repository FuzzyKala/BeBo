package com.example.bebo.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavController(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomePage(modifier, navController)
        }
        composable(
            route = "second/{paras}",
            arguments = listOf(
                navArgument("paras") {
                    type = NavType.StringType
                }
            )
        ) {
            SecondPage(modifier, navController,it.arguments?.getString("paras"))
        }
    }
}