package com.example.bebo.todo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>) : TodoUiState
    data object Error : TodoUiState
    data object Loading : TodoUiState
}


class TodoViewModel : ViewModel() {


    private var _todoUiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)
    val todoUiState: TodoUiState get() = _todoUiState

    private val _todos = mutableStateListOf<Todo>()
    val todos: List<Todo> get() = _todos

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val todos = TodosApi.getInstance().getTodos()
                if (todos.isNotEmpty()) {
//                    _todos.clear()
//                    _todos.addAll(todos)
                    _todoUiState = TodoUiState.Success(_todos)
                } else {
                    _todoUiState = TodoUiState.Error
                }
            } catch (e: Exception) {
                _todoUiState = TodoUiState.Error
                Log.e("TodoViewModel", "Error fetching todos: ${e.message}")
            }
        }
    }
}


