package com.example.bebo.main

import ExerciseAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bebo.R
import com.example.bebo.lazyBone.ExerciseRepository
import com.example.bebo.lazyBone.ExerciseViewModel
import com.example.bebo.lazyBone.RetrofitInstance

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = ExerciseRepository(RetrofitInstance.api)
        viewModel = ExerciseViewModel(repository)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ExerciseAdapter()
        recyclerView.adapter = adapter

        viewModel.exercises.observe(this) { exercises ->
            Log.d("MainActivity", "Exercise list size: ${exercises?.size ?: 0}")
            exercises?.let { adapter.submitList(it) }
        }

        viewModel.fetchExercises("shoulders")
    }

}


//class MainActivity : ComponentActivity() {
//
//    @RequiresApi(Build.VERSION_CODES.N)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            BeBoTheme {
//
////                HeartRate()
////                StateButton()
////                BMI()
////                TodoApp()
//
//
//////                        DistanceTransfer()
//////                        TemperateConverter()
//////                        DiceRoll()
//////                        LoginForm()
//////                        ListOfSensors()
//////                        MyApp()
//////                        Electricity()
//////                        Calories("Calories")
//////                    AppNavController(modifier = Modifier.padding(innerPadding))
////                TopNavigationApp()
////                BottomNavigationApp()
//
//            }
//        }
//    }
//}


