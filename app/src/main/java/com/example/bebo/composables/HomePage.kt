package com.example.bebo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePage(modifier: Modifier, navController: NavController) {
    var textInput by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = modifier,
            text = "Home Page"
        )
        OutlinedTextField(
            value = textInput,
            onValueChange = {textInput = it}
        )
        Button(
            onClick = { navController.navigate("second/$textInput") },
            enabled = textInput.isNotEmpty()
        ) {
            Text("To the Second page")
        }
    }

}
