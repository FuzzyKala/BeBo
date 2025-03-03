package com.example.bebo.todo

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(todoViewModel: TodoViewModel = koinViewModel()) {
    val uiState by todoViewModel.todoUiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Todos") }) }
    ) { innerPadding ->
        Log.d("uiState","$uiState")
        TodoScreen(Modifier.padding(innerPadding), uiState)
    }
}

@Composable
fun TodoScreen(modifier: Modifier, uiState: TodoUiState) {
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen()
        is TodoUiState.Success -> TodoList(modifier, uiState.todoList)
        is TodoUiState.Error -> ErrorScreen()
    }
}