package com.example.bebo.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun State() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column {
        Button(
            onClick = {
                count++
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Counter is $count now.")
        }

    }
}