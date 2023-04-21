package com.jatinvashisht.cleannotes.features.featureNote.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

/**
 * DAO to apply operations on **[NoteDatabase]**.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
@Dao
interface NoteDao {

    /**
     * suspend function to get all notes in database.
     * @return List of NoteEntity.
     * */
    @Query("SELECT * FROM notetable ORDER BY primaryKey DESC")
    suspend fun getAllNotes() : List<NoteEntity>

    /**
     * suspend function to insert new note.
     * @param [newNotes] List of [NoteEntity] to insert.
     * */
    @Insert(NoteEntity::class, onConflict = REPLACE)
    suspend fun insertNote(newNotes: List<NoteEntity>)


    /**
     * suspend function to delete a note.
     * @param [notesToDelete] list of [NoteEntity] to be deleted.
     * */
    @Delete(NoteEntity::class)
    suspend fun deleteNoteByNoteEntity(notesToDelete: List<NoteEntity>)

    /**
     * suspend function to delete a note by title.
     * @param [title] title of note.
     * */
    @Query("DELETE FROM notetable WHERE title = :title")
    suspend fun deleteNoteByTitle(title: String)

    /**
     * suspend function to delete a list of notes by their respective titles.
     *
     * @param [title] List of String containing titles of each note to delete.
     * */
    @Query("DELETE FROM notetable WHERE title = :title")
    suspend fun deleteNoteByTitleList(title: List<String>)

    /**
     * suspend function to get a not by its title.
     *
     * @param [title] title of note.
     * */
    @Query("SELECT * from notetable WHERE title = :title LIMIT 1")
    suspend fun getNoteByTitle(title: String): NoteEntity

    /**
     * suspend function to get a not by its title.
     *
     * @param [titleList] titles of note in a List.
     * */
    @Query("SELECT * FROM notetable WHERE title = :titleList")
    suspend fun getAllNotesByTitleList(titleList: List<String>): List<NoteEntity>
}