package com.jatinvashisht.cleannotes.features.featureNote.data.local.mapper

import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteEntity
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel

/**
 * Mapper function to convert [NoteModel] to [NoteEntity]
 *
 * @return [NoteEntity]
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
fun NoteModel.toNoteEntity(): NoteEntity = NoteEntity(
    title = title,
    body = body,
    categories = categories,
    tags = tags,
)