package com.medialink.mynoteapps.ui.main

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.medialink.mynoteapps.database.Note
import com.medialink.mynoteapps.databinding.ItemNoteBinding
import com.medialink.mynoteapps.helper.NoteDiffCallback
import com.medialink.mynoteapps.ui.insert.NoteAddUpdateActivity

class NoteAdapter internal constructor(private val mActivity: Activity):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    private val listNotes = ArrayList<Note>()

    fun setListNotes(listNotes: List<Note>) {
        val diffCallback = NoteDiffCallback(this.listNotes, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNotes.clear()
        this.listNotes.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            with(binding) {
                tvItemTitle.text = note.title
                tvItemDate.text = note.date
                tvItemDescription.text = note.description
                cvItemNote.setOnClickListener {
                    val intent = Intent(mActivity, NoteAddUpdateActivity::class.java)
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, adapterPosition)
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, note)
                    mActivity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE)
                }
                Log.d("TAG", "bind: $absoluteAdapterPosition vs $adapterPosition vs $bindingAdapterPosition")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }
}