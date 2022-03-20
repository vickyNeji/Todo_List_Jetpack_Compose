package com.example.todolistcompose.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    @Insert
    fun insertNote(note:Note)

    @Query("Select * from notes_table")
    fun getAllNotes():LiveData<List<Note>>

}