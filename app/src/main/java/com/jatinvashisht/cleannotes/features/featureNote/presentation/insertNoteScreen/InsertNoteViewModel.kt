package com.jatinvashisht.cleannotes.features.featureNote.presentation.insertNoteScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import com.jatinvashisht.cleannotes.features.featureNote.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InsertNoteViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val repo: INoteRepository,
) :
    ViewModel() {

    init {
        viewModelScope.launch {
            val categories = repo.getAllDistinctCategories()
            Timber.tag(TAG).d("categories are \n%s", categories.toString())
        }
    }

    private val _noteTitleTextState = mutableStateOf<String>("")
    val noteTitleTextState: State<String> = _noteTitleTextState

    private val _noteBodyTextState = mutableStateOf<String>("")
    val noteBodyTextState: State<String> = _noteBodyTextState

    companion object {
        const val TAG = "insertnoteviewmodel"
    }

    fun onTitleTextFieldValueChange(newTitle: String) {
        _noteTitleTextState.value = newTitle
    }

    fun onBodyTextFieldValueChange(newBody: String) {
        _noteBodyTextState.value = newBody
    }

    fun insertNote() {
        viewModelScope.launch {
            insertNoteUseCase(NoteModel(title = "This is a random title.", tags = listOf("android", "web"), category = "android")).collectLatest {
                Timber.tag(TAG).d("Result after inserting note is \n%s", it.toString())
            }

            val categories = repo.getAllDistinctCategories()
            Timber.tag(TAG).d("categories are \n%s", categories.toString())
        }
    }
}