package com.medialink.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.medialink.mynoteapps.database.Note
import com.medialink.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application): ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<PagedList<Note>> =
        LivePagedListBuilder(mNoteRepository.getAllNotes(), 20).build()
}