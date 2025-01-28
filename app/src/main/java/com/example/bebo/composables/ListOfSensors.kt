package com.example.bebo.composables

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListOfSensors() {
    val ctx = LocalContext.current
    val sensorManager = ctx.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val sensorList: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
    Column {
        Text(

            text = "Available Sensor",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()

        )
        LazyColumn {
            sensorList.forEach { sensor: Sensor ->
                item {
                    HorizontalDivider()
                    Text(
                        text = sensor.name,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }

    }
}