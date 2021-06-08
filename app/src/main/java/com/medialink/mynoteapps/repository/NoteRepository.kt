package com.medialink.mynoteapps.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.medialink.mynoteapps.database.Note
import com.medialink.mynoteapps.database.NoteDao
import com.medialink.mynoteapps.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {

    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(): DataSource.Factory<Int, Note> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute {
            mNotesDao.insert(note)
        }
    }

    fun delete(note: Note) {
        executorService.execute {
            mNotesDao.delete(note)
        }
    }

    fun edit(note: Note) {
        executorService.execute {
            mNotesDao.update(note)
        }
    }

}