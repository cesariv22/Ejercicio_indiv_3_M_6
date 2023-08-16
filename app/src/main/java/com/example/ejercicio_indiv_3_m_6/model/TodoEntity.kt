package com.example.ejercicio_indiv_3_m_6.model


import androidx.room.Entity
import androidx.room.PrimaryKey

//Representa la tabla de la base de datos
@Entity(tableName = "todo_table")

data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nameTodo: String
)