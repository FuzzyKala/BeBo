package com.example.bebo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

import com.example.bebo.composables.TopNavigationApp
import com.example.bebo.ui.theme.BeBoTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeBoTheme {
//                Scaffold(
//                    topBar = {
//                        TopBar(title = "test app", onMenuClick = {/*TODO*/ })
//                    },
//                    modifier = Modifier.fillMaxSize()
//                ) { innerPadding ->
//
////                        HeartRate()
////                        BMI()
////                        DistanceTransfer()
////                        TemperateConverter()
////                        DiceRoll()
////                        LoginForm()
////                        ListOfSensors()
////                        MyApp()
////                        Electricity()
////                        State()
////                        Calories("Calories")
////                    AppNavController(modifier = Modifier.padding(innerPadding))
                TopNavigationApp()
//                BottomNavigationApp()

//                }
            }
        }
    }
}

