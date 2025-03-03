package com.example.bebo.todo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bebo.todo.api.Todo
import com.example.bebo.todo.api.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todoList: List<Todo>) : TodoUiState
    data object Error : TodoUiState
    data object Loading : TodoUiState
}

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    private val _todoUiState = MutableStateFlow<TodoUiState>(TodoUiState.Loading)
    val todoUiState = _todoUiState.asStateFlow()

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList = _todoList.asStateFlow()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                _todoUiState.value = TodoUiState.Loading
                val result: List<Todo> = repository.fetchTodos()
                Log.d("TodoViewModel", "API Response: $result")

                if (result.isNotEmpty()) {
                    _todoUiState.value = TodoUiState.Success(result)
                } else {
                    _todoUiState.value = TodoUiState.Error
                }

            } catch (e: Exception) {
                _todoUiState.value = TodoUiState.Error
                Log.e("TodoViewModel", "API Error: ${e.message}")
            }
        }
    }
}


