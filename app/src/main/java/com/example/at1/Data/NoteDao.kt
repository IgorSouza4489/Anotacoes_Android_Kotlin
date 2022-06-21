
package com.example.at1.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.at1.model.Note

//Data access object, objeto de acesso a dados


@Dao
interface NoteDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(note : Note)


    @Delete
     fun delete(note: Note)
//    @Dao
//    interface LivroDao {
//        //...
//        @Query("SELECT * FROM livro")
//        fun all() : Array<Livro>
//    }

    @Query("SELECT * FROM notesTable") //comando database
    fun getAllNotes(): LiveData<List<Note>>

    @Update
     fun update(note: Note)


     //@Query("Delete FROM notesTable")
     //fun deleteAll(note: Note)

//     //Erro no DeleteAll error: Query method parameters should either be a type that can be converted into a database column or a List / Array that contains such type. You can consider adding a Type Adapter for this.
//    com.example.at1.model.Note note);
//     //https://stackoverflow.com/questions/53885749/query-method-parameters-should-either-be-a-type-that-can-be-converted-into-a-dat
//    @Query("DELETE FROM notesTable")
//     fun deleteAll(note: Note)

}