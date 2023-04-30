package com.jatinvashisht.cleannotes.features.featureNote.domain.usecase

import com.jatinvashisht.cleannotes.core.Resource
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetAllDistinctCategoriesUseCase @Inject constructor(
    private val noteRepository: INoteRepository
) {
    companion object {
        const val TAG = "getalldistinctcategoriesusecase"
    }
    suspend operator fun invoke(): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading<List<String>>())
            val distinctCategories = noteRepository.getAllDistinctCategories()
            emit(Resource.Success<List<String>>(data = distinctCategories))
        } catch (exception: Exception) {
            Timber.tag(TAG).d("error occurred while fetching categories\n%s", exception.toString())
            emit(Resource.Error<List<String>>(error = "Error occurred while fetching categories."))
        }
    }
}