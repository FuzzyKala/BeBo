package com.example.bebo.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.example.bebo.bmi.BMI
import com.example.bebo.ui.theme.BeBoTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeBoTheme {

//                HeartRate()
//                StateButton()

                BMI()
////                        DistanceTransfer()
////                        TemperateConverter()
////                        DiceRoll()
////                        LoginForm()
////                        ListOfSensors()
////                        MyApp()
////                        Electricity()
////                        Calories("Calories")
////                    AppNavController(modifier = Modifier.padding(innerPadding))
//                TopNavigationApp()
//                BottomNavigationApp()

            }
        }
    }
}


