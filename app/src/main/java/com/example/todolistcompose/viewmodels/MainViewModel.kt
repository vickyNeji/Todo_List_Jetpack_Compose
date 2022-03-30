package com.example.todolistcompose.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var _currentNote= MutableLiveData<Note>()
    val currentNote:LiveData<Note> = _currentNote

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }

    fun getAllNotes()= repository.getAllNotes()

    fun getSingleNote(noteId:Int){
        viewModelScope.launch(Dispatchers.IO) {
           val data=repository.getSingleNote(noteId)
            Log.d("TAG", "getSingleNote:${data} ")
            _currentNote.postValue(data)
        }

    }

}