package com.example.bebo.heartRateLimit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class HeartRateViewModel : ViewModel() {

    var ageInput by mutableStateOf("")
    private val df = DecimalFormat("#.##").apply { roundingMode = RoundingMode.CEILING }
    private val age: Int
        get() = ageInput.toIntOrNull() ?: 0
    val upperLimit: Float
        get() = if (age > 0) df.format((220 - age) * 0.85f).toFloat() else 0f
    val lowerLimit: Float
        get() = if (age > 0) df.format((220 - age) * 0.65f).toFloat() else 0f

}