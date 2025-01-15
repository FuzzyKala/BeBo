package com.example.bebo.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bebo.R

@Composable
fun DiceRoll(modifier: Modifier = Modifier) {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageSource = when (result){
        1 ->R.drawable.dice_1
        2 ->R.drawable.dice_2
        3 ->R.drawable.dice_3
        4 ->R.drawable.dice_4
        5 ->R.drawable.dice_5
        else ->R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageSource),
            contentDescription = "dice image $result"
        )
        Button(onClick = {
            result = (1..6).random()
            Log.d("button", "dice roll $result")
        }) {
            Text(text = stringResource(R.string.roll_it))
        }
    }
}
