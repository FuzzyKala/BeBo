package com.example.bebo.todo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

//data class Success(val todo:List<Todo>)

const val BASE_URL = "https://jsonplaceholdert.typicode.com/"

interface TodosApi {
    @GET("Todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        @Volatile
        private var todosService: TodosApi? = null

        fun getInstance(): TodosApi {
//            if (todosService === null) {
//                todosService = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(TodosApi::class.java)
//            }
//            return todosService!!
            return todosService ?: synchronized(this) {
                todosService ?: Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
                    .also { todosService = it }
            }
        }
    }
}