package com.example.bebo.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.ui.Modifier
import com.example.bebo.todo.TodoScreen
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
//                BMI()
                TodoScreen()
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


