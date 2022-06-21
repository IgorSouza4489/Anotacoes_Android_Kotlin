package com.example.at1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.at1.R
import com.example.at1.model.Note

class NoteRecyclerViewAdapter(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    //val noteClickDeleteAllInterface: NoteClickAllDeleteInterface,
    val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {
    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvnote = itemView.findViewById<TextView>(R.id.idTVNote)
        val tvdate = itemView.findViewById<TextView>(R.id.idTVDate)
        val tvdsc = itemView.findViewById<TextView>(R.id.idTVds)
        val tvdelete = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_recyclerview_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvnote.setText(allNotes.get(position).noteTitulo)
        holder.tvdsc.setText(allNotes.get(position).noteDescriçao)
        holder.tvdate.setText("Última atualização : " + allNotes.get(position).data)
        holder.tvdelete.setOnClickListener {

            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))

        }

        holder.itemView.setOnClickListener {

            noteClickInterface.onNoteClick(allNotes.get(position))
        }
    }

    override fun getItemCount() = allNotes.size


    fun updateList(newList: List<Note>) {

        allNotes.clear()

        allNotes.addAll(newList)

        notifyDataSetChanged()
        //https://stackoverflow.com/questions/71980733/recycler-view-doesnt-update-list-after-notifydatasetchanged
    }
}

interface NoteClickDeleteInterface {

    fun onDeleteIconClick(note: Note)
}

interface NoteClickAllDeleteInterface {

    fun onDeleteAllIconClick(note: Note)
}


interface NoteClickInterface {

    fun onNoteClick(note: Note)
}