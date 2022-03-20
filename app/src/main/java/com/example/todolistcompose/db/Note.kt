package com.example.todolistcompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(val title: String, val content: String){
@PrimaryKey(autoGenerate = true)
var id:Int?=null
}
