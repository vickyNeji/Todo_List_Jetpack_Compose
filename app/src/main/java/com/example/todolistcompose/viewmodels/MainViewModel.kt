package com.example.todolistcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistcompose.db.Note
import com.example.todolistcompose.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository): ViewModel() {

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }

    fun getAllNotes()= repository.getAllNotes()

}