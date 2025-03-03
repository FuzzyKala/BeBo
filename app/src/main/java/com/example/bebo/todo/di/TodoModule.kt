package com.example.bebo.todo.di

import com.example.bebo.todo.TodoViewModel
import com.example.bebo.todo.api.RetrofitInstance
import com.example.bebo.todo.api.TodoRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todoModule = module {
    single { RetrofitInstance.api }
    single { TodoRepository(get()) }
    viewModel { TodoViewModel(get()) }
}
