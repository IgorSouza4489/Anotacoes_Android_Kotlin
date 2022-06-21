//package com.example.at1
//
//import android.content.Intent
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.at1.databinding.ActivityFaleConoscoBinding
//import com.example.at1.databinding.ActivityMainBinding
//
//class FaleConoscoActivity : AppCompatActivity() {
//
//    lateinit var binding: ActivityFaleConoscoBinding
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFaleConoscoBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        binding.voltartoinitial.setOnClickListener{
//            finish()
//        }
//
//        binding.btnenviar.setOnClickListener{
//            enviaremail()
//        }
//
//    }
//
//    fun toastMessage(mensagem: String) {
//        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
//    }
//
//
//    fun enviaremail(){
//        //val tvemail = binding.tvemail.text.toString()
//        val tvtexto = binding.tvtexto.text.toString()
//        val tvassunto = binding.tvassunto.text.toString()
//        if (tvtexto.isNotEmpty() && tvassunto.isNotEmpty()){
//            var intent = Intent(Intent.ACTION_SENDTO).apply{
//                data = Uri.parse("mailto:igor.ssouza@al.infnet.edu.br")
//                putExtra(Intent.EXTRA_TEXT,tvtexto)
//                putExtra(Intent.EXTRA_SUBJECT,tvassunto)
//            }
//            if(intent.resolveActivity(packageManager) != null ){
//                startActivity(intent)
//            }
//            else{
//                toastMessage("Não existe nenhuma aplicação em seu celular que possa enviar formulário")
//            }
//        }
//        else{
//            toastMessage("Preencha os campos")
//        }
//    }
//}
