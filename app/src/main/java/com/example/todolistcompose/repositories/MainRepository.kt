package com.example.todolistcompose.repositories

import com.example.todolistcompose.db.Note
import com.example.todolistcompose.db.NotesDao
import javax.inject.Inject

class MainRepository @Inject constructor(private val notesDao: NotesDao) {

     fun insertNote(note: Note)=notesDao.insertNote(note)

     fun getAllNotes()=notesDao.getAllNotes()

    suspend fun getSingleNote(noteId:Int)=  notesDao.getSingleNote(noteId)

    suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)

}