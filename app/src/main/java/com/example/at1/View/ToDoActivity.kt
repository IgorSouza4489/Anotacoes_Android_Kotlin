package com.example.at1.View

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.at1.Adapter.NoteClickDeleteInterface
import com.example.at1.Adapter.NoteClickInterface
import com.example.at1.Adapter.NoteRecyclerViewAdapter
import com.example.at1.R
import com.example.at1.ViewModel.NoteViewModel
import com.example.at1.databinding.ActivityToDoBinding
import com.example.at1.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


class ToDoActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface{

    //, NoteClickAllDeleteInterface

    lateinit var notesRV:RecyclerView
    lateinit var addFAB: FloatingActionButton
    lateinit var viewModel: NoteViewModel

    lateinit var binding1: ActivityToDoBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityToDoBinding.inflate(layoutInflater)
        val view = binding1.root
        var nome = intent.getStringExtra("nome")
        //nesse momento meu android studio parou de funcionar propriamente, está em "analyzing" infinitamente impossibilitando que eu dê um id para um widget por exemplo
        //já que eu precisaria refatorar e o android não me permite isso.
        binding1.textView.text = nome.toString()

        drawerLayout = binding1.drawerLayout
        drawerView = binding1.navView
        draweritem()
        setContentView(view)

        notesRV = binding1.notesRV
        addFAB = binding1.idFAB
        notesRV.layoutManager = LinearLayoutManager(this)
        val noteRVAdapter = NoteRecyclerViewAdapter(this, this, this)
        notesRV.adapter = noteRVAdapter
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                noteRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {

            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity(intent)
            finish()

        }
        binding1.btnvoltartomain.setOnClickListener{
            finish()
       }

    }

    override fun onNoteClick(note: Note) {
        val intent = Intent(this, EditNoteActivity::class.java)
        intent.putExtra("noteTipo", "Edit")
        intent.putExtra("noteTitulo", note.noteTitulo)
        intent.putExtra("noteDescriçao", note.noteDescriçao)
        intent.putExtra("noteId", note.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "${note.noteTitulo} Excluído", Toast.LENGTH_LONG).show()
    }

//    override fun onDeleteAllIconClick(note: Note) {
//        viewModel.deleteAll(note)
//        Toast.makeText(this, "${note.noteTitulo} Apagamos tudinho", Toast.LENGTH_LONG).show()
//    }

    fun toastMessage(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    fun draweritem(){
        binding1.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.diario ->{
                    toastMessage("Diário selecionado")
                    return@setNavigationItemSelectedListener true
                }
                R.id.checklist ->{
                    toastMessage("Checklist selecionado")
                    return@setNavigationItemSelectedListener true
                }
                R.id.sair -> {
                    return@setNavigationItemSelectedListener true
                }
                else -> {
                    return@setNavigationItemSelectedListener true
                }
            }
        }
    }

    
}