package com.example.ejercicio_indiv_3_m_6.viewUI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ejercicio_indiv_3_m_6.R
import com.example.ejercicio_indiv_3_m_6.databinding.FragmentFirstBinding
import com.example.ejercicio_indiv_3_m_6.model.TodoEntity
import com.example.ejercicio_indiv_3_m_6.viewModel.TodoViewModel
import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TodoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnList.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btnAddToDo.setOnClickListener {
            saveTodo()
        }
    }
    private fun saveTodo() {
        val nameTodo = binding.etAddToDo.text.toString().trim()
        if (nameTodo.isNotEmpty()){
            val todo = TodoEntity(nameTodo = nameTodo)
            viewModel.insertTodo(todo)
            Snackbar.make(binding.root, "ToDo agregado con éxito!!", Snackbar.LENGTH_SHORT).setAnchorView(binding.root).show()
        }   else {
            Toast.makeText(context, "Campo vacío, ingresar ToDo", Toast.LENGTH_LONG).show()
        }
        binding.etAddToDo.text.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}