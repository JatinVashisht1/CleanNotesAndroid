package com.jatinvashisht.cleannotes.features.featureNote.domain.usecase

import com.jatinvashisht.cleannotes.core.Resource
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

/**
 * Use Case to insert a note in database.
 *
 * @property [noteRepository] Note Repository to work with notes.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
class InsertNoteUseCase @Inject constructor(private val noteRepository: INoteRepository) {
    private val logger = Timber.tag("InsertNoteUseCase")
    suspend operator fun invoke (noteModel: NoteModel) : Flow<Resource<String>> = flow {
        try {

            emit(Resource.Loading<String>())

            noteRepository.insertNotes(listOf(noteModel))

            emit(Resource.Success<String>("Note inserted successfully."))
        } catch (exception: Exception) {
            logger.d("Error occurred while inserting note in InsertNoteUseCase.kt\n$exception")

            emit(Resource.Error<String>("Unable to insert note. Try again."))
        }
    }
}