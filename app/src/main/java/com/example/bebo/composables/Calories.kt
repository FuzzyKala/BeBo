package com.example.bebo.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun Calories(appName: String) {
    var weightInput by remember { mutableStateOf("") }
    val weight = weightInput.toIntOrNull() ?: 0
    var isMale by remember { mutableStateOf(true) }
    var intensity by remember { mutableFloatStateOf(1.3f) }
    var result by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Title(appName)
        Body(
            weightInput = weightInput,
            setWeightInput = { weightInput = it },
            isMale = isMale,
            setIsMale = { isMale = it },
            setIntensity = { intensity = it }
        )
        Text(
            text = "You need ${result} calories per day",
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )

        Calculation(
            isMale = isMale,
            weight = weight,
            intensity = intensity,
            setResult = { result = it }
        )
        Log.d("Calories", "$intensity")
        Log.d("Calories", "$result")

    }
}

@Composable
fun Title(appName: String) {
    Text(
        text = appName,
        style = MaterialTheme.typography.headlineMedium
            .copy(color = MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun Body(
    weightInput: String,
    setWeightInput: (String) -> Unit,
    isMale: Boolean,
    setIsMale: (Boolean) -> Unit,
    setIntensity: (Float) -> Unit
) {
    WeightField(weightInput = weightInput, setWeightInput = setWeightInput)
    GenderField(isMale = isMale, setIsMale = setIsMale)
    IntensityField(setIntensity = setIntensity)
}

@Composable
fun WeightField(
    weightInput: String,
    setWeightInput: (String) -> Unit
) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = { value -> setWeightInput(value) },
        label = {
            Text("Your Weight here")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun GenderField(
    isMale: Boolean,
    setIsMale: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 52.dp),
        horizontalAlignment = Alignment.Start,

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = isMale,
                onClick = { setIsMale(true) }
            )
            Text("Male")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = !isMale,
                onClick = { setIsMale(false) }
            )
            Text("Female")
        }
    }
}

@Composable
fun IntensityField(
    setIntensity: (Float) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Light") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val items = listOf("Light", "Usual", "Moderate", "Hard", "Very hard")
    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {
        OutlinedTextField(
            readOnly = true,
            value = selectedText,
            onValueChange = { },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text("Select intensity") },
            trailingIcon = {
                Icon(icon, "Select intensity",
                    Modifier.clickable { expanded = !expanded })
            }

        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            items.forEach { item ->
                val intensity: Float = when (item) {
                    "Light" -> 1.3f
                    "Usual" -> 1.5f
                    "Moderate" -> 1.7f
                    "Hard" -> 2f
                    "Very hard" -> 2.2f
                    else -> 0.0f
                }
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        setIntensity(intensity)
                        selectedText = item
                        expanded = false
                    }
                )
            }
        }
    }

}

@Composable
fun Calculation(
    isMale: Boolean,
    weight: Int,
    intensity: Float,
    setResult: (Int) -> Unit
) {
    Button(
        onClick = {
            if (isMale) {
                setResult(((879 + 10.2 * weight) * intensity).toInt())
            } else {
                setResult(((795 + 7.18 * weight) * intensity).toInt())
            }
        }
    ) {
        Text(text = "CALCULATE")
    }

}



