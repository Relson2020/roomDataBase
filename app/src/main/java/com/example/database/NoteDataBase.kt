package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntities::class],version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDAO

    companion object{

        @Volatile
        private var INSTANCE : NoteDataBase? = null

        fun getNOteDataBaseReference(context: Context): NoteDataBase? {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context
                    ,NoteDataBase::class.java,"noteDataBase").build()
                }
                return INSTANCE
            }
            return INSTANCE
        }

    }
}
