package com.example.ejercicio_indiv_3_m_6

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio_indiv_3_m_6.databinding.ItemTodoBinding
import com.example.ejercicio_indiv_3_m_6.model.TodoEntity

class AdapterToDo(var itemList: List<TodoEntity>) :
    RecyclerView.Adapter<AdapterToDo.ToDoViewHolder>() {

    class ToDoViewHolder(binding:ItemTodoBinding):RecyclerView.ViewHolder(binding.root) {
        val todo:TextView =binding.tvToDoAdd
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.todo.text = currentItem.nameTodo

    }

    override fun getItemCount()= itemList.size
}