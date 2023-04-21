package com.jatinvashisht.cleannotes.features.featureNote.data.local.repository

import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteDao
import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteDatabase
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(noteDatabase: NoteDatabase) : INoteRepository {

    private val noteDao: NoteDao

    init {
        noteDao = noteDatabase.noteDao
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteByTitle(title: String): NoteModel {
        TODO("Not yet implemented")
    }

    override suspend fun getAllNotesByTitleList(titleList: List<String>): List<NoteModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(noteModel: NoteModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNoteByTitle(title: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNoteByTitleList(title: List<String>) {
        TODO("Not yet implemented")
    }
}