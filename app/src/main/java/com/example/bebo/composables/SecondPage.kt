package com.example.bebo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SecondPage(
    modifier: Modifier,
    navController: NavController,
    paras: String?
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = modifier,
            text = "Second Page"
        )
        Text(
            text = "The Text from Home page is $paras"
        )
        Button(
            onClick = { navController.navigate("home") }
        ) {
            Text("To the Home page")
        }
    }

}