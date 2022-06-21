
package com.example.at1.Data

import androidx.lifecycle.LiveData
import com.example.at1.model.Note

class NoteRepository(private val notesDao: NoteDao) {


    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

     fun insert(note: Note) {
        notesDao.insert(note)
    }

     fun delete(note: Note){
        notesDao.delete(note)
    }

     fun update(note: Note){
        notesDao.update(note)
    }

//    fun deleteall(note: Note){
//        notesDao.deleteAll(note)
//    }
}