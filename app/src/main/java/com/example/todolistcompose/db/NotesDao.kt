package com.example.todolistcompose.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note:Note)

    @Query("Select * from notes_table")
    fun getAllNotes():LiveData<List<Note>>

    @Query("Select * from notes_table where id=:noteId LIMIT 1")
    suspend fun getSingleNote(noteId:Int):Note


    @Delete
    suspend fun deleteNote(note: Note)

}