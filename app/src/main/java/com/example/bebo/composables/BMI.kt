package com.example.bebo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
fun BMI(modifier: Modifier = Modifier) {
    var heightInput by remember { mutableStateOf("") }
    var weightInput by remember { mutableStateOf("") }
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight = weightInput.toFloatOrNull() ?: 0.0f
    val bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.body_mass_index),
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier
        )
        OutlinedTextField(
            value = heightInput,
            onValueChange = { heightInput = it.replace(",", ".") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xD5FFFFFF)),
            label = {
                Text(
                    text = stringResource(R.string.label_height),
                    color = Color(0xD5FFFFFF)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.placeholder_height),
                    color = Color(0xD5FFFFFF)
                )
            }
        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { weightInput = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color.White),
            label = { Text(text = stringResource(R.string.label_weight), color = Color.White) },
            placeholder = {
                Text(
                    text = stringResource(R.string.placeholder_weight),
                    color = Color.White
                )
            }
        )
        Text(text = stringResource(R.string.bmi_result, df.format(bmi)))
    }
}
