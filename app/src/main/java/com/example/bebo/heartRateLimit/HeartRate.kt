package com.example.bebo.heartRateLimit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bebo.R

@Composable
fun HeartRate(heartRateViewModel: HeartRateViewModel = viewModel()) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(R.string.heart_rate_title),
                style = MaterialTheme.typography.headlineMedium.copy(color = Color(0xFF0B4BD6))
            )
            OutlinedTextField(
                value = heartRateViewModel.ageInput,
                onValueChange = { heartRateViewModel.ageInput = it },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = stringResource(R.string.age)) },
                placeholder = {
                    Text(text = stringResource(R.string.placeholder_heart_rate))
                }
            )

            Text(
                text = stringResource(
                    R.string.heart_rate_limits,
                    heartRateViewModel.lowerLimit,
                    heartRateViewModel.upperLimit
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


}