package com.example.bebo.todo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TodoList(modifier = Modifier.padding(innerPadding), todoViewModel.todos)

    }
}