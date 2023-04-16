package com.jatinvashisht.cleannotes.features.featureNote.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

/**
 * DAO to apply operations on **NoteDatabase**.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
@Dao
interface NoteDao {

    /**
     * suspend function to get all notes in database.
     * @return List of NoteEntity.
     * */
    @Query("SELECT * FROM notetable")
    suspend fun getAllNotes() : List<NoteEntity>

    /**
     * suspend function to insert new note.
     * @param [newNotes] List of notes to insert.
     * */
    @Insert(NoteEntity::class, onConflict = REPLACE)
    suspend fun insertNote(newNotes: List<NoteEntity>)


    /**
     * suspend function to delete a note.
     * @param [notesToDelete] list of notes to be deleted.
     * */
    @Delete(NoteEntity::class)
    suspend fun deleteNoteByNoteEntity(notesToDelete: List<NoteEntity>)

    /**
     * suspend function to delete a note by title.
     * @param [title] title of note.
     * */
    @Query("DELETE FROM notetable WHERE title = :title")
    suspend fun deleteNoteByTitle(title: String)
}