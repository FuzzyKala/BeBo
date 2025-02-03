package com.example.bebo.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class BMIViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val df = DecimalFormat("#.##").apply { roundingMode = RoundingMode.CEILING }

    val bmi: Float
        get() {
            val height = heightInput.toFloatOrNull() ?: 0.0f
            val weight = weightInput.toFloatOrNull() ?: 0.0f
            return if (weight > 0.0f && height > 0f)
                df.format(weight / (height * height)).toFloat() else 0.0f
        }

}