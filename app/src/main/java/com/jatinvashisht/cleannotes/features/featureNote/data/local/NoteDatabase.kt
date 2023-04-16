package com.jatinvashisht.cleannotes.features.featureNote.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jatinvashisht.cleannotes.features.featureNote.data.local.converters.ConverterListOfStringToString

/**
 * Abstract class inheriting **RoomDatabase** class
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
@Database(entities = [NoteEntity::class], version = 1)
@TypeConverters(ConverterListOfStringToString::class)
abstract class NoteDatabase: RoomDatabase() {
    /**
     * abstract object of **NoteDao**.
     * */
    abstract val noteDao: NoteDao
    companion object {
        /**
         * name of database.
         * */
        const val DATABASE_NAME = "notedatabase"
    }
}