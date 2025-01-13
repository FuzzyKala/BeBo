package com.example.bebo.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TemperateConverter(modifier: Modifier = Modifier) {
    var isFahrenheitSelected by remember { mutableStateOf(true) }
    var input by remember { mutableStateOf("") }
    val inputAsFloat = input.toFloatOrNull() ?: 0.0f
    val resultText = calculateTemperature(inputAsFloat, isFahrenheitSelected)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fahrenheit/Celsius",
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.tertiary)
        )
        TemperatureInputField(
            input = input, onInputChanged = { input = it }, modifier = Modifier.fillMaxWidth()
        )
        TemperatureRadioButtons(
            isFahrenheitSelected = isFahrenheitSelected,
            onSelectedChanged = { isFahrenheitSelected = it },
            modifier = Modifier
        )

        Text(
            text = resultText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            textAlign = TextAlign.Start
        )

    }
}


@Composable
fun TemperatureInputField(
    input: String, onInputChanged: (String) -> Unit, modifier: Modifier = Modifier
) {
    OutlinedTextField(value = input,
        onValueChange = onInputChanged,
        singleLine = true,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xD5FFFFFF)),
        placeholder = { Text(text = "Type the temperature here!") },
        label = { Text(text = "Temperature") })
}

@Composable
fun TemperatureRadioButtons(
    isFahrenheitSelected: Boolean,
    onSelectedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isFahrenheitSelected,
            onClick = { onSelectedChanged(true) },
            modifier = modifier
                .size(30.dp)
                .padding(horizontal = 10.dp)
        )
        Text(text = "Fahrenheit to Celsius")
    }

    Row(
        modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = !isFahrenheitSelected,
            onClick = { onSelectedChanged(false) },
            modifier = modifier
                .size(30.dp)
                .padding(end = 10.dp, start = 10.dp)
        )
        Text(text = "Celsius to Fahrenheit")
    }


}

@Composable
fun calculateTemperature(inputAsFloat: Any, isFahrenheitSelected: Boolean): String {
    val df = DecimalFormat("#.##").apply { roundingMode = RoundingMode.CEILING }
    return if (isFahrenheitSelected) {
        val fahrenheit = df.format(inputAsFloat).toDouble()
        val celsius = df.format((fahrenheit - 32) * 5 / 9).toDouble()
        "$fahrenheit °F equals to $celsius °C."
    } else {
        val celsius = df.format(inputAsFloat).toDouble()
        val fahrenheit = df.format((celsius * 1.8) + 32).toDouble()
        "$celsius °C equals to $fahrenheit °F."
    }
}
