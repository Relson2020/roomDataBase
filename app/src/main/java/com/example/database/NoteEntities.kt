package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profileDetails")
data class NoteEntities (  @PrimaryKey val employeeId : Int
                          ,  val name : String
                          , val phone : Int
                          , val email : String)
