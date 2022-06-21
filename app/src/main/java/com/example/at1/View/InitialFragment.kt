package com.example.at1.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.example.at1.databinding.FragmentInitialBinding


class InitialFragment : Fragment() {

    private var _binding: FragmentInitialBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInitialBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnentrar.setOnClickListener {
            var nome = binding.tvnome.text.toString()
            val intent = Intent(activity, ToDoActivity::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
        binding.faleconosco.setOnClickListener {
            val direction = InitialFragmentDirections
            val action = direction.actionInitialFragmentToFaleConoscoFragment3()
            findNavController(view).navigate(action)
        }
        return view
    }




}