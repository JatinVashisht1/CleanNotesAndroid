package com.jatinvashisht.cleannotes.features.featureNote.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notetable")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Long? = null,
    val title: String = "",
    val body: String = "",
    val categories: List<String> = listOf(),
    val tags: List<String> = listOf(),
)
