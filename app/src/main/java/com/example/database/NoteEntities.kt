package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profileDetails")
data class NoteEntities ( @PrimaryKey(autoGenerate = true)
                          val employeeId : Int
                          , val name : String
                          , val phone : Int
                          , val email : String)
