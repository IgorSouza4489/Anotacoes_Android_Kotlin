package com.example.at1.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.at1.databinding.FragmentFaleConoscoBinding


class FaleConoscoFragment : Fragment() {


    private var _binding: FragmentFaleConoscoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFaleConoscoBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.voltartoinitial.setOnClickListener{
            findNavController().popBackStack()
        }


        binding.btnenviar.setOnClickListener{
            enviaremail()
        }
        return view
    }
    fun toastMessage(mensagem: String) {
        Toast.makeText(activity, mensagem, Toast.LENGTH_SHORT).show()
    }


    fun enviaremail(){
        val pm = activity!!.packageManager
        //val tvemail = binding.tvemail.text.toString()
        val tvtexto = binding.tvtexto.text.toString()
        val tvassunto = binding.tvassunto.text.toString()
        if (tvtexto.isNotEmpty() && tvassunto.isNotEmpty()){
            var intent = Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:igor.ssouza@al.infnet.edu.br")
                putExtra(Intent.EXTRA_TEXT,tvtexto)
                putExtra(Intent.EXTRA_SUBJECT,tvassunto)
            }
            if(intent.resolveActivity(pm) != null ){
                startActivity(intent)
            }
            else{
                toastMessage("Não existe nenhuma aplicação em seu celular que possa enviar formulário")
            }
        }
        else{
            toastMessage("Preencha os campos")
        }
    }

}