package com.example.bebo.todo.api

import android.util.Log

class TodoRepository(private val api: TodosApiService) {
    suspend fun fetchTodos(): List<Todo> {
        return try {
            val response = api.getTodos()
            Log.e("TodoRepository", "API Response: $response")
            response
        } catch (e: Exception) {
            Log.e("TodoRepository", "API Call Failed: ${e.message}", e)
            throw Exception("API Error: ${e.message}")
        }
    }

}