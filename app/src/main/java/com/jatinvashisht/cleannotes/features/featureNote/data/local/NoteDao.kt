package com.jatinvashisht.cleannotes.features.featureNote.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notetable")
    suspend fun getAllNotes() : List<NoteEntity>

    @Insert(NoteEntity::class, onConflict = REPLACE)
    suspend fun insertNote(newNotes: List<NoteEntity>)

    @Delete(NoteEntity::class)
    suspend fun deleteNoteByNoteEntity(notesToDelete: List<NoteEntity>)

    @Query("DELETE FROM notetable WHERE title = :title")
    suspend fun deleteNoteByTitle(title: String)
}