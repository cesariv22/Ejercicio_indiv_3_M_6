package com.example.ejercicio_indiv_3_m_6.repository


import androidx.lifecycle.LiveData
import com.example.ejercicio_indiv_3_m_6.model.TodoEntity
import com.example.ejercicio_indiv_3_m_6.model.TodoDao

// Responsabilidad exponer los datos para el ViewModel

class TodoRepository(private val todoDao: TodoDao) {

    // Este value va a contener toda la información de la BD,  todas las tareas
    val listAllTodo: LiveData<List<TodoEntity>> = todoDao.getAllTodo()

    suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: TodoEntity) {
        todoDao.updateTodo(todo)
    }

    suspend fun deleteOneTodo(todo: TodoEntity) {
        todoDao.deleteOneTodo(todo)
    }

    suspend fun deleteAllTodo() {
        todoDao.deleteAllTodo()
    }
}