package com.example.bebo.lazyBone

import android.util.Log

// real implementation for the function getExercisesByBodyPart
class ExerciseRepository(private val api: ExerciseApiService) {

    suspend fun getExercisesByBodyPart(bodyPart: String): List<Exercise>? {
        return try {
            val response = api.getExercisesByBodyPart(bodyPart)
            Log.d("ExerciseRepository", "Raw API Response: $response") // ✅ Debugging
            response
        } catch (e: Exception) {
            Log.e("ExerciseRepository", "API Call Failed: ${e.message}", e) // 🔥 Print full error
            null
        }
    }
}
