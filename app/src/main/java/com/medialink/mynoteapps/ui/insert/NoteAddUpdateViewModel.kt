package com.medialink.mynoteapps.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.medialink.mynoteapps.database.Note
import com.medialink.mynoteapps.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application): ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }
    fun update(note: Note) {
        mNoteRepository.edit(note)
    }
    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}