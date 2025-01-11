package com.example.bebo.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bebo.R
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun HeartRate(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    val age = input.toIntOrNull() ?: 0
    val upper = if (age > 0) (220 - age) * 0.85f else 0
    val lower = if (age > 0) (220 - age) * 0.65f else 0
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.heart_rate_title),
            style = MaterialTheme.typography.headlineMedium.copy(color = Color(0xFF0B4BD6))
        )
        TextField(
            value = input,
            onValueChange = { input = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.age)) },
            placeholder = {
                Text(text = stringResource(R.string.placeholder_heart_rate))
            }
        )

        Text(
            text = stringResource(
                R.string.heart_rate_limits,
                df.format(lower),
                df.format(upper)
            ),
            modifier = Modifier
                .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.LightGray)
        )

    }
}