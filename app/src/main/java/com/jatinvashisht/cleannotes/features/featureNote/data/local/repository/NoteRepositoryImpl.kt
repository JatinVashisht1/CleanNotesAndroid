package com.jatinvashisht.cleannotes.features.featureNote.data.local.repository

import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteDao
import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteDatabase
import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteEntity
import com.jatinvashisht.cleannotes.features.featureNote.data.local.mapper.toNoteEntity
import com.jatinvashisht.cleannotes.features.featureNote.data.local.mapper.toNoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(noteDatabase: NoteDatabase) : INoteRepository {

    private val noteDao: NoteDao

    init {
        noteDao = noteDatabase.noteDao
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        val allNotes = noteDao.getAllNotes()
        val allNotesNoteModel = mutableListOf<NoteModel>()

        allNotes.forEach{
            it.toNoteModel()
            allNotesNoteModel.add(it.toNoteModel())
        }

        return allNotesNoteModel
    }

    override suspend fun getNoteByTitle(title: String): NoteModel {
        val noteEntity = noteDao.getNoteByTitle(title = title)

        return noteEntity.toNoteModel()
    }

    override suspend fun getAllNotesByTitleList(titleList: List<String>): List<NoteModel> {
        val allNoteListEntity = noteDao.getAllNotesByTitleList(titleList = titleList)
        val allNoteListModel = mutableListOf<NoteModel>()

        allNoteListEntity.forEach {
            allNoteListModel.add(it.toNoteModel())
        }

        return allNoteListModel
    }

    override suspend fun insertNotes(listNoteModel: List<NoteModel>) {
        val listNoteEntity = mutableListOf<NoteEntity>()

        listNoteModel.forEach {
            listNoteEntity.add(it.toNoteEntity())
        }

        noteDao.insertNote(listNoteEntity)
    }

    override suspend fun deleteNoteByTitle(title: String) {
        noteDao.deleteNoteByTitle(title = title)
    }

    override suspend fun deleteNoteByTitleList(title: List<String>) {
        noteDao.deleteNoteByTitleList(title = title)
    }
}