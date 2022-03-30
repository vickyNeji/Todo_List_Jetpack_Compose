package com.example.todolistcompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(var title: String, var content: String,var colorIndex:Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
