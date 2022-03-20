package com.example.todolistcompose.di

import android.content.Context
import androidx.room.Room
import com.example.todolistcompose.db.NotesDao
import com.example.todolistcompose.db.NotesDatabase
import com.example.todolistcompose.utils.Constants.NOTES_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(context
        ,NotesDatabase::class.java,
            NOTES_DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(database: NotesDatabase):NotesDao{
        return database.getRunDao()
    }

}