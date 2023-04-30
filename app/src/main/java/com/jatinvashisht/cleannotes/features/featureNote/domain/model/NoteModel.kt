package com.jatinvashisht.cleannotes.features.featureNote.domain.model

/**
 * Data class to represent note domain model.
 *
 * @param [title] Title of the note.
 * @param [body] Body of the note.
 * @param [category] category that current note falls in.
 * @param [tags] List of tags applied to current note to get identified easily in future.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
data class NoteModel(
    val title: String = "",
    val body: String = "",
    val category: String = "",
    val tags: List<String> = listOf(),
)
