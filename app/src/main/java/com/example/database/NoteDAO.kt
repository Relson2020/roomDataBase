package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {

    @Insert
    suspend fun insert(note : NoteEntities)

    @Query("SELECT * FROM profileDetails")
    fun getAllNotes() : LiveData<List<NoteEntities>>
}