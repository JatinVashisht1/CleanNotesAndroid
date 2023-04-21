package com.jatinvashisht.cleannotes.features.featureNote.data.local.mapper

import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteEntity
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel

/**
 * Mapper function to convert [NoteEntity] to [NoteModel]
 *
 * @return [NoteModel]
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
fun NoteEntity.toNoteModel(): NoteModel = NoteModel(
    title = title,
    body = body,
    categories = categories,
    tags = tags,
)