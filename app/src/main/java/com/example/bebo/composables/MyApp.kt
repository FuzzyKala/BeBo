package com.example.bebo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val appModifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "My title",
            modifier = appModifier,
            style = MaterialTheme.typography.titleLarge
        )
        OutlinedTextField(
            value="",
            onValueChange = { /*TODO*/},
            modifier = appModifier
        )
        Button(
            onClick = {/*TODO*/},
            modifier = appModifier
        ) {
            Text("Submit")
        }
    }
}