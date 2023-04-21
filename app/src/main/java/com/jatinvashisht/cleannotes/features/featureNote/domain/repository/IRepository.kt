package com.jatinvashisht.cleannotes.features.featureNote.domain.repository

import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel

/**
 * Interface acting as business rule for any repository implementation to work with notes.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
interface IRepository {

    /**
     * suspend function to get all notes from database as a List of [NoteModel].
     *
     * @return List<[NoteModel]>
     * */
    suspend fun getAllNotes(): List<NoteModel>

    /**
     * suspend function to get note by *title*.
     *
     * @param [title] title of note to retrieve.
     *
     * @return [NoteModel]
     * */
    suspend fun getNoteByTitle(title: String): NoteModel

    /**
     * suspend function to get notes by title list.
     *
     * @param [titleList] List<[String]> containing titles of respective notes.
     *
     * @return List<[NoteModel]>
     * */
    suspend fun getAllNotesByTitleList(titleList: List<String>): List<NoteModel>

    /**
     * suspend function to insert a note in database.
     *
     * @param [noteModel] note of type [NoteModel] to insert in database.
     * */
    suspend fun insertNote(noteModel: NoteModel)


    /**
     * suspend function to delete a note by it title.
     * */
    suspend fun deleteNoteByTitle(title: String)

    /**
     * suspend function to delete a list of notes by their respective titles.
     *
     * @param [title] List of String containing titles of each note to delete.
     * */
    suspend fun deleteNoteByTitleList(title: List<String>)
}