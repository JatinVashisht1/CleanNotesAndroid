package com.jatinvashisht.cleannotes.features.featureNote.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jatinvashisht.cleannotes.features.featureNote.data.local.converters.ConverterListOfStringToString

@Database(entities = [NoteEntity::class], version = 1)
@TypeConverters(ConverterListOfStringToString::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
    companion object {
        const val DATABASE_NAME = "notedatabase"
    }
}