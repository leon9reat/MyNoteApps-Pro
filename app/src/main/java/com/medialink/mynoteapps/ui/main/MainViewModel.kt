package com.medialink.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.medialink.mynoteapps.database.Note
import com.medialink.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application): ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}