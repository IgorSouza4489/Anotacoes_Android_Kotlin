
package com.example.at1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class Note (@ColumnInfo(name = "titulo")val noteTitulo :String,@ColumnInfo(name = "descriçao")val noteDescriçao:String,@ColumnInfo(name = "data")val data :String) {

    @PrimaryKey(autoGenerate = true) var id = 0
}