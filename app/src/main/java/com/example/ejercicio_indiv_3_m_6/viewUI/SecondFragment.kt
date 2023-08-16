package com.example.ejercicio_indiv_3_m_6.viewUI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio_indiv_3_m_6.AdapterToDo
import com.example.ejercicio_indiv_3_m_6.R
import com.example.ejercicio_indiv_3_m_6.databinding.FragmentSecondBinding
import com.example.ejercicio_indiv_3_m_6.viewModel.TodoViewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterTodo : AdapterToDo
    private val viewModel: TodoViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.allTodo.observe(viewLifecycleOwner) {todo ->
            adapterTodo.itemList = todo.toMutableList()
            adapterTodo.notifyDataSetChanged()
        }

        binding.btnBackInit.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.btnDeleteListToDo.setOnClickListener {
            viewModel.deleteAllTodo()
        }
    }

    private fun setupRecyclerView() {
        adapterTodo = AdapterToDo(emptyList())
        binding.rvToDo.layoutManager = LinearLayoutManager(requireContext())
        binding.rvToDo.adapter = adapterTodo
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}