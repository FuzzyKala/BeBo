package com.example.bebo.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Electricity(modifier: Modifier = Modifier) {

    var consumptionInput by remember { mutableStateOf("") }
    var price by remember { mutableStateOf(0.0f) }
    var isVATChecked by remember { mutableStateOf(false) }
    val consumption = consumptionInput.toFloatOrNull()
    val df = java.text.DecimalFormat("#.##").apply {
        roundingMode = RoundingMode.CEILING
    }

    val costOfElectricity = if (consumption != null) {
        if (isVATChecked) {
            price * consumption + price * consumption * 0.1f
        } else {
            price * consumption
        }
    } else {
        0.0f
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Cost of electricity",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = consumptionInput,
            onValueChange = { consumptionInput = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Consumption in kWh") },
            modifier = Modifier
        )
        Text(
            "Price/kWh is ${df.format(price)}"
        )
        Slider(
            value = price,
            onValueChange = { price = it },
            valueRange = 0.0f..3.0f,
            modifier = Modifier
                .scale(0.9f)
                .size(320.dp, 10.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isVATChecked,
                onCheckedChange = { isVATChecked = it })
            Text("VAT 10%")
        }
        Text("Total Cost: ${df.format(costOfElectricity)}")

    }

}