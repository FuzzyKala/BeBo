package com.example.bebo.composables


import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bebo.R
import java.math.RoundingMode
import java.text.DecimalFormat


@RequiresApi(Build.VERSION_CODES.N)
@Composable

fun DistanceTransfer(modifier: Modifier = Modifier) {
    var milesInput by remember { mutableStateOf("") }
    var kmsInput by remember { mutableStateOf("") }
    var isMilesFocused by remember { mutableStateOf(false) }
    var isKmsFocused by remember { mutableStateOf(false) }
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.distance_transfer),
            style = MaterialTheme.typography.headlineMedium.copy(color = Color(0xFFB2FF59))
        )
        OutlinedTextField(
            value = milesInput,
            onValueChange = {
                milesInput = it
                if (isMilesFocused){
                    var miles = milesInput.toFloatOrNull() ?: 0.0f
                    kmsInput = if (miles > 0) (df.format(miles * 1.60934f)).toString() else ""

                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { isMilesFocused = it.isFocused },
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xD5FFFFFF)),
            label = {
                Text(
                    text = stringResource(R.string.miles), color = Color(0xD5FFFFFF)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.type_the_distance_in_miles), color = Color(0xD5FFFFFF)
                )
            })

        OutlinedTextField(value = kmsInput,
            onValueChange = {
                kmsInput = it
                if (isKmsFocused){
                    var kms = kmsInput.toFloatOrNull() ?: 0.0f
                    milesInput = if (kms > 0) (df.format((kms * 0.621371f).toDouble())).toString() else ""

                }
                            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { isKmsFocused = it.isFocused },
            textStyle = MaterialTheme.typography.bodySmall.copy(color = Color(0xD5FFFFFF)),
            label = {
                Text(
                    text = stringResource(R.string.kilometers), color = Color(0xD5FFFFFF)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.type_the_distance_in_kilometers), color = Color(0xD5FFFFFF)
                )
            })
    }
}