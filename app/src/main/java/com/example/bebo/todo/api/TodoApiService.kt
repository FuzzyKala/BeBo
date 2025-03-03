package com.example.bebo.todo.api

import retrofit2.http.GET

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

interface TodosApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}