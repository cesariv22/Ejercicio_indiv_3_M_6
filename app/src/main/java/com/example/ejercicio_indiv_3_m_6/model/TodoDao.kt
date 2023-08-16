package com.example.ejercicio_indiv_3_m_6.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {

    // Insertar una tarea. Tiene una estrategia si se repite el Id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    //Actualizar una tarea
    @Update
    suspend  fun updateTodo(todo: TodoEntity)

    //Borrar una tarea
    @Delete
    suspend  fun deleteOneTodo(todo: TodoEntity)

    //Borrar todas las tareas
    @Query("DELETE FROM TODO_TABLE")
    suspend fun deleteAllTodo()

    //Traer todos las tareas
    @Query("SELECT * FROM TODO_TABLE ORDER BY id ASC")
    fun getAllTodo(): LiveData<List<TodoEntity>>
}