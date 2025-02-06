package com.example.bebo.lazyBone

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ExerciseViewModel(private val repository: ExerciseRepository) : ViewModel() {


    private val _exercises = MutableLiveData<List<Exercise>?>()
    val exercises: MutableLiveData<List<Exercise>?> get() = _exercises

    fun fetchExercises(bodyPart: String) {
        viewModelScope.launch {
            try {
                val result = repository.getExercisesByBodyPart(bodyPart)
                Log.d("ExerciseViewModel", "API Response: $result")
                _exercises.value = result
            } catch (e: Exception) {
                Log.e("ExerciseViewModel", "API Error: ${e.message}")
            }
        }
    }
}