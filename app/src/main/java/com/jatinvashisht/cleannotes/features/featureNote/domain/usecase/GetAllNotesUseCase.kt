package com.jatinvashisht.cleannotes.features.featureNote.domain.usecase

import com.jatinvashisht.cleannotes.core.Resource
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

/**
 * Use Case to get all notes in database.
 *
 * @property [noteRepository] Note Repository to work with notes.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
class GetAllNotesUseCase @Inject constructor(private val noteRepository: INoteRepository){
    private val logger = Timber.tag("GetAllNotesUseCase")
    suspend operator fun invoke() : Flow<Resource<List<NoteModel>>> = flow {
        try {
            emit(Resource.Loading<List<NoteModel>>())

            val noteModelList = noteRepository.getAllNotes()

            emit(Resource.Success<List<NoteModel>>(data = noteModelList))
        } catch(exception: Exception) {
            logger.d("Error occurred while getting all notes in GetAllNotesUseCase.kt\n$exception")

            emit(Resource.Error<List<NoteModel>>("Error occurred while loading notes."))
        }
    }
}
