package com.example.bebo.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bebo.todo.TodoApp
import com.example.bebo.ui.theme.BeBoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeBoTheme {

//                HeartRate()
//                StateButton()
//                BMI()
                TodoApp()
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


