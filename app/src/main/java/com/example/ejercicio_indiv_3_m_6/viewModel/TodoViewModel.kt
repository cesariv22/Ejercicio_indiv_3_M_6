package com.example.ejercicio_indiv_3_m_6.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercicio_indiv_3_m_6.model.TodoDataBase
import com.example.ejercicio_indiv_3_m_6.model.TodoEntity
import com.example.ejercicio_indiv_3_m_6.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    // Conexión con el repositorio
    private val repository : TodoRepository

    // LIVE DATA QUE EXPONE LA INFO DEL MODELO
    val allTodo: LiveData<List<TodoEntity>>

    init{
        // obteniendo instancia del dao
        val todoDao = TodoDataBase.getDataBase(application).getTodoDao()
        repository = TodoRepository(todoDao)
        allTodo = repository.listAllTodo
    }

    fun insertTodo(todo: TodoEntity)= viewModelScope.launch {
        repository.insertTodo(todo)
    }

    fun updateTodo(todo: TodoEntity)= viewModelScope.launch {
        repository.updateTodo(todo)
    }

    fun deleteOneTodo(todo: TodoEntity)= viewModelScope.launch {
        repository.deleteOneTodo(todo)
    }

    fun deleteAllTodo()=viewModelScope.launch {
        repository.deleteAllTodo()
    }

    // Para seleccionar algun Elemento
    private val selectedTodo : MutableLiveData<TodoEntity?> = MutableLiveData()

    // funcion para recibir una tarea seleccionado desde el Rv
    fun selected(todo: TodoEntity?){
        // guarda lo que estamos seleccionando
        selectedTodo.value= todo
    }

    // para mostrar los elementos luego de una seleccion Recibir  el objeto seleccionado
    fun selectedItem(): LiveData<TodoEntity?> = selectedTodo

}