package com.example.at1.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.at1.databinding.ActivityEditNoteBinding
import com.example.at1.model.Note
import com.example.at1.ViewModel.NoteViewModel
import java.text.SimpleDateFormat
import java.util.*

class EditNoteActivity : AppCompatActivity() {
    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button
    lateinit var voltarbtn: ImageView
    lateinit var binding2: ActivityEditNoteBinding

    lateinit var viewModel: NoteViewModel
    var noteID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityEditNoteBinding.inflate(layoutInflater)
        val view = binding2.root
        setContentView(view)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        noteTitleEdt = binding2.idEdtNoteName
        noteEdt = binding2.idEdtNoteDesc
        saveBtn = binding2.idBtn
        voltarbtn = binding2.voltartodo

        val noteType = intent.getStringExtra("noteTipo")
        if (noteType.equals("Edit")) {
            val noteTitle = intent.getStringExtra("noteTitulo")
            val noteDescription = intent.getStringExtra("noteDescriçao")
            noteID = intent.getIntExtra("noteId", -1)
            saveBtn.setText("Atualizar")
            noteTitleEdt.setText(noteTitle)
            noteEdt.setText(noteDescription)
        } else {
            saveBtn.setText("Salvar")
        }

        voltarbtn.setOnClickListener{
            startActivity(Intent(this, ToDoActivity::class.java))
            this.finish()
        }

        saveBtn.setOnClickListener {

            val noteTitle = noteTitleEdt.text.toString()
            val noteDescription = noteEdt.text.toString()

            if (noteType.equals("Edit")) {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val date = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val datagora: String = date.format(Date())
                    val updatedNote = Note(noteTitle, noteDescription, datagora)
                    updatedNote.id = noteID
                    viewModel.updateNote(updatedNote)
                    Toast.makeText(this, "Anotação atualizada...", Toast.LENGTH_LONG).show()
                }
            } else {
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val date = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val datagora: String = date.format(Date())

                    viewModel.addNote(Note(noteTitle, noteDescription, datagora))
                    //Toast.makeText(this, "$noteTitle Adicionada", Toast.LENGTH_LONG).show()
                }
            }

            startActivity(Intent(applicationContext, ToDoActivity::class.java))
            finishAndRemoveTask()
        }
    }
}