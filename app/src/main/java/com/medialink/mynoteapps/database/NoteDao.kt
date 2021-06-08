package com.medialink.mynoteapps.database

import androidx.paging.DataSource
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM note ORDER BY id ASC")
    //fun getAllNotes(): LiveData<List<Note>>
    fun getAllNotes(): DataSource.Factory<Int, Note>    // paging

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Note>)
}